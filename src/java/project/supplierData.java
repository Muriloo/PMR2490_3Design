/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import utils.Transacao;
import java.sql.Statement;
/**
 *
 * @author Arthur
 */
public class supplierData {
    
    public void insertMaterial(supplierDO supplier, Transacao tr) throws Exception{
        Connection con = tr.obterConexao();
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(dia);
        String day= sdf.format(dia);
        ArrayList<String> materials = new ArrayList<String> ();
        Object[] materials2 = supplier.getMaterials();
        for(int i=0; i<materials2.length;i++){
            String mat =(String) materials2[i];
            String sql = "select * from material where material_name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mat);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int matId = rs.getInt("id");
                String sql2 = "select * from supplier_material_relation where material_name = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setString(1, mat);
                ResultSet rs2 = ps2.executeQuery();
                if(!rs2.next()){
                    String sql3 = "insert into supplier_material_relation set supplier_id=?, material_id=?";
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setInt(1,supplier.getId());
                    ps3.setInt(2,rs.getInt("id"));
                    ps3.executeUpdate();
                }else{
                    String sql3 = "insert into material set material_name=?";
                    PreparedStatement ps3 = con.prepareStatement(sql3);
                    ps3.setString(2,mat);
                    ps3.executeUpdate();
                }
            }
        }
    }
    
    public int insertAddress(supplierAddressDO address, Transacao tr) throws Exception{
        Connection con = tr.obterConexao();
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(dia);
        String day= sdf.format(dia);
        
        if (address.getId()==-1){
            System.out.println("----------------------------------------------------address.getId()==-1");
                 String sql = "insert into supplier_address (supplier_address_id, supplier_address_country, supplier_address_state, supplier_address_city,"
                 + " supplier_address_street, supplier_address_complement, supplier_address_postalcode, created_at, updated_at) "
                         + "values('"+address.getSupplier()+"','"+address.getCountry()+"','"+address.getState()+"','"+address.getCity()+"','"+address.getStreet()+"',"
                         + "'"+address.getComplement()+"','"+address.getPostalcode()+"','"+day+"','"+day+"')";
                 System.out.println(sql);
                 Statement stmt = con.createStatement();
                 stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                 ResultSet rs = stmt.getGeneratedKeys();
                    if ( rs.next() ){
                        address.setId(rs.getInt(1));
                    }
        }else{
            System.out.println("----------------------------------------------------address.getId()!=-1");
                 
                 String sqlA = "update supplier_address set supplier_address_country=?, supplier_address_state=?, supplier_address_city=?,"
                 + " supplier_address_street=?, supplier_address_complement=?, supplier_address_postalcode=?, updated_at=? where supplier_address_id=?";
                 PreparedStatement psA = con.prepareStatement(sqlA);
                 psA.setString(1,address.getCountry());
                 psA.setString(2,address.getState());
                 psA.setString(3,address.getCity());
                 psA.setString(4,address.getStreet());
                 psA.setString(5,address.getComplement());
                 psA.setString(6,address.getPostalcode());
                 psA.setString(7, day);
                 psA.setInt (8, address.getSupplier());
                 psA.executeUpdate();
             }
        
        return address.getId();
    }
        
    public int insertContact(contactInfoDO contact, Transacao tr) throws Exception{
        Connection con = tr.obterConexao();
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(dia);
        String day= sdf.format(dia);
        if (contact.getId()==-1){
                String sql = "insert into contact (contact_supplier_id, contact_name, contact_position, contact_email,"
                 + " contact_phone, created_at, updated_at) values('"+contact.getSupplierId()+"','"+contact.getName()+"','"+contact.getPosition()+""
                        + "','"+contact.getEmail()+"','"+contact.getPhone()+"','"+day+"','"+day+"')";
                 
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.getGeneratedKeys();
                if ( rs.next() ){
                    contact.setId(rs.getInt(1));
                }
        }else{ 
                String sqlC = "update contact set contact_name=?, contact_position=?, contact_email=?,"
                + " contact_phone=?, updated_at=? where contact_supplier_id=?";
                PreparedStatement psC = con.prepareStatement(sqlC);
                psC.setString(1,contact.getName());
                psC.setString(2,contact.getPosition());
                psC.setString(3,contact.getEmail());
                psC.setString(4,contact.getPhone());
                psC.setString (5, day);
                psC.setInt(6,contact.getSupplierId());
                psC.executeUpdate();
        }
        return contact.getId();
    }
    
    public int insertBank(BankInfoDO bank, Transacao tr) throws Exception{
        Connection con = tr.obterConexao();
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(dia);
        String day= sdf.format(dia);
        if (bank.getId()==-1){
                String sql = "insert into bank_info (bank_info_supplier_id, bank_info_number, bank_info_agency, bank_info_account,"
                 + " bank_info_cpf_cnpj, created_at, updated_at) values('"+bank.getSupplierId()+"','"+bank.getBankNumber()+"','"+bank.getAgency()+"','"+bank.getAccount()+"','"+bank.getCnpjCpf()+"','"+day+"','"+day+"')";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.getGeneratedKeys();
                if ( rs.next() ){
                    bank.setId(rs.getInt(1));
                }
        }else{
             String sqlB = "update bank_info set bank_info_number=?, bank_info_agency=?, bank_info_account=?,"
             + " bank_info_cpf_cnpj=?, updated_at=? where bank_info_supplier_id=?";
             PreparedStatement psB = con.prepareStatement(sqlB);
             psB.setString(1,bank.getBankNumber());
             psB.setString(2,bank.getAgency());
             psB.setString(3,bank.getAccount());
             psB.setString(4,bank.getCnpjCpf());
             psB.setString (5, day);
             psB.setInt(6,bank.getSupplierId());
             psB.executeUpdate();
        }
        
        return bank.getId();
    }
    public void update(supplierDO supplier, Transacao tr) throws Exception{
        System.out.println("entra no update");
        Connection con = tr.obterConexao();
        System.out.println("cria conexão");
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(dia);
        String day= sdf.format(dia);
        System.out.println("--------------------------------------supplierName"+supplier.getName());
        String sql = "update supplier set supplier_name=?, supplier_evaluation=?,supplier_capacity_id=?, supplier_comment=?, supplier_description=?, updated_at=? where id=?";
        System.out.println("fez sql:"+sql);
        PreparedStatement ps =con.prepareStatement(sql);
        System.out.println("prepara statement");
        ps.setString(1, supplier.getName());
        ps.setDouble(2, supplier.getEval());
        ps.setInt(3, supplier.getCapacityId());
        ps.setString(4, supplier.getComment());
        ps.setString(5, supplier.getDescription());
        ps.setString(6, day);
        ps.setInt(7, supplier.getId());
        System.out.println("antes da query");
        ps.executeUpdate();
       
     System.out.println("executou a query de update");
    }

    public int include(supplierDO supplier, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     System.out.println("supplier_evaluation:"+supplier.getEval());
     String sql = "insert into supplier (supplier_name, supplier_evaluation, supplier_capacity_id, supplier_comment, supplier_description, created_at, updated_at)"
             + " values ('"+supplier.getName()+"', "+supplier.getEval()+", "+supplier.getCapacityId()+", '"+supplier.getComment()+"', '"+supplier.getDescription()+"', '"+day+"', '"+day+"');";
     System.out.println(sql);
     Statement stmt = con.createStatement();
     stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
     ResultSet rs = stmt.getGeneratedKeys();
     if ( rs.next() ){
         supplier.setId(rs.getInt(1));
     }
     System.out.println("executou a query de inserção");
     return supplier.getId();
 } // include supplier
    
    
    public void delete (supplierDO supplier, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "update supplier set deleted=1, deleted_at=? where id=?;";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString (1, day);
     ps.setInt (2,supplier.getId());
     int result = ps.executeUpdate();
     
 } // include supplier
    
    
    public Vector getSuppliers(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from supplier where deleted=0;";
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector suppliers = new Vector();
     while (rs.next()) {
        supplierDO s = new supplierDO();
        s.setId (rs.getInt("id"));
        s.setName (rs.getString("supplier_name"));
        s.setEval(rs.getDouble("supplier_evaluation"));
        s.setCapacityId(rs.getInt("supplier_capacity_id"));
        s.setComment(rs.getString("supplier_comment"));
        s.setDescription(rs.getString("supplier_description"));
        System.out.println("ID fornecedor="+s.getId());
        
        // contatos
        
        Vector contacts = new Vector();
        String sql1 = "select * from contact where contact_supplier_id=? and deleted=0;";
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, s.getId());
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()){
            contactInfoDO ci = new contactInfoDO();
            ci.setPhone(rs1.getString("contact_phone"));
            ci.setEmail(rs1.getString("contact_email"));
            ci.setPosition(rs1.getString("contact_position"));
            ci.setName(rs1.getString("contact_name"));
            ci.setSupplierId(rs1.getInt("contact_supplier_id"));
            ci.setId(rs1.getInt("id"));
            contacts.add(ci);
            System.out.println("Email: "+ci.getEmail());
        }
        
        s.setContactInfo(contacts);
        //fecha contatos
        
        //endereços
        Vector Addresses = new Vector();
        String sql2 = "select * from supplier_address where supplier_address_id=? and deleted=0;";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, s.getId());
        ResultSet rs2 = ps2.executeQuery();
        while ( rs2.next() ){
            supplierAddressDO sa = new supplierAddressDO();
            sa.setComplement(rs2.getString("supplier_address_complement"));
            sa.setPostalcode(rs2.getString("supplier_address_postalcode"));
            sa.setStreet(rs2.getString("supplier_address_street"));
            sa.setCity(rs2.getString("supplier_address_city"));
            sa.setState(rs2.getString("supplier_address_state"));
            sa.setCountry(rs2.getString("supplier_address_country"));
            sa.setSupplier(rs2.getInt("supplier_address_id"));
            sa.setId(rs2.getInt("id"));
            System.out.println("cidade: "+sa.getCity());
            Addresses.add(sa);
        }
        s.setAddress(Addresses);
        
        // fecha endereços
        
        //bankInfos
        Vector bankInfos = new Vector();
        String sql3 = "select * from bank_info where bank_info_supplier_id=? and deleted=0;";
        PreparedStatement ps3 = con.prepareStatement(sql3);
        ps3.setInt(1,s.getId());
        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()){
            BankInfoDO bi = new BankInfoDO();
            bi.setCnpjCpf(rs3.getString("bank_info_cpf_cnpj"));
            bi.setAccount(rs3.getString("bank_info_account"));
            bi.setAgency(rs3.getString("bank_info_agency"));
            bi.setBankNumber(rs3.getString("bank_info_number"));
            bi.setSupplierId(rs3.getInt("bank_info_supplier_id"));
            bi.setId(rs3.getInt("id"));
            bankInfos.add(bi);
            System.out.println("ID do banco="+rs3.getInt("id"));
        }
        s.setBankInfo(bankInfos);
        // fecha bankInfos
        
        //materiais
        ArrayList<String> materials = new ArrayList<String> ();
        String sql4 = "select m.material_name from supplier_material_relation r "
                + "inner join material m on m.id=r.material_id and m.deleted=0 "
                + "where r.supplier_id = ? and r.deleted=0;";
        PreparedStatement ps4 = con.prepareStatement(sql4);
        ps4.setInt(1,s.getId());
        ResultSet rs4 = ps4.executeQuery();
        while(rs4.next()){
           System.out.println(rs4.getString("material_name"));
           materials.add(rs4.getString("material_name"));
        }
       
        s.setMaterials( materials.toArray());
        
        suppliers.add(s);  // suppliers <- s;
       
     } //while rs
     return suppliers;
  } // gets suppliers
    
}
