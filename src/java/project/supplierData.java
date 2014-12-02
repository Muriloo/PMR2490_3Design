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

    public void include(supplierDO supplier, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "insert into supplier (supplier_name, supplier_evaluation, supplier_capacity_id, supplier_comment, supplier_description, created_at, updated_at)"
             + " values ('"+supplier.getName()+"', "+supplier.getEval()+", "+supplier.getCapacityId()+", '"+supplier.getComment()+"', '"+supplier.getDescription()+"', '"+day+"', '"+day+"');";
     System.out.println(sql);
     Statement stmt = con.createStatement();
     stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
     ResultSet rs = stmt.getGeneratedKeys();
     if ( rs.next() ){
         supplier.setId(rs.getInt(1));
         int result;
         //address
     Vector addresses = supplier.getAddress();
     if (null != addresses){
         System.out.println("----------------------------------------addresses != null");
         for (int i=0;i<addresses.size();i++){
             String sqlA = "insert into supplier_address (supplier_address_id, supplier_address_country, supplier_address_state, supplier_address_city,"
             + " supplier_address_street, supplier_address_complement, supplier_address_postalcode, created_at, updated_at) values(?,?,?,?,?,?,?,?,?)";
             supplierAddressDO address = (supplierAddressDO) addresses.elementAt(i);
             address.setSupplier(supplier.getId());
             PreparedStatement psA = con.prepareStatement(sqlA);
             System.out.println("supplierID:"+supplier.getId());
             psA.setInt(1,supplier.getId());
             psA.setString(2,address.getCountry());
             psA.setString(3,address.getState());
             psA.setString(4,address.getCity());
             psA.setString(5,address.getStreet());
             psA.setString(6,address.getComplement());
             psA.setString(7,address.getPostalcode());
             psA.setString (8, day);
             psA.setString (9, day);
             result = psA.executeUpdate();
         }
     }//address
     //contacts
     Vector contacts = supplier.getContactInfo();
     if (null != contacts){
         System.out.println("----------------------------------------contacts != null");
         for (int i=0;i<contacts.size();i++){
             String sqlC = "insert into contact (contact_supplier_id, contact_name, contact_position, contact_email,"
             + " contact_phone, created_at, updated_at) values(?,?,?,?,?,?,?)";
             contactInfoDO contact = (contactInfoDO) contacts.elementAt(i);
             contact.setSupplierId(supplier.getId());
             PreparedStatement psC = con.prepareStatement(sqlC);
             psC.setInt(1,supplier.getId());
             psC.setString(2,contact.getName());
             psC.setString(3,contact.getPosition());
             psC.setString(4,contact.getEmail());
             psC.setString(5,contact.getPhone());
             psC.setString (6, day);
             psC.setString (7, day);
             result = psC.executeUpdate();
         }
     }//contacts
     //banks
     Vector banks = supplier.getBankInfo();
      
     if (null != banks){
         System.out.println("----------------------------------------banks != null");
         for (int i=0;i<banks.size();i++){
             String sqlB = "insert into bank_info (bank_info_supplier_id, bank_info_number, bank_info_agency, bank_info_account,"
             + " bank_info_cpf_cnpj, created_at, updated_at) values(?,?,?,?,?,?,?)";
             BankInfoDO bank = (BankInfoDO) banks.elementAt(i);
             bank.setSupplierId(supplier.getId());
             PreparedStatement psB = con.prepareStatement(sqlB);
             psB.setInt(1,supplier.getId());
             psB.setString(2,bank.getBankNumber());
             psB.setString(3,bank.getAgency());
             psB.setString(4,bank.getAccount());
             psB.setString(5,bank.getCnpjCpf());
             psB.setString (6, day);
             psB.setString (7, day);
             result = psB.executeUpdate();
             System.out.println("----------------------------------------query banks");
         }
     }//banks
     
     System.out.println("executou a query de inserção");
     
     }
     
     
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
