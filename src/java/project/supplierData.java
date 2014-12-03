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
import utils.Transacao;

/**
 *
 * @author Arthur
 */
public class supplierData {
    /*
    private int _id;
    private String _name;
    private double _evaluation; //decimal (2,1)
    private int _capacity_id;
    private String _comment;
    private String _description;
    */ 
    public void include(supplierDO supplier, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "insert into supplier (supplier_name, supplier_evaluation, supplier_capacity_id, supplier_comment, supplier_description, created_at, updated_at)"
             + " values (?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, supplier.getName());
     ps.setDouble(2, supplier.getEval());
     ps.setInt(3, supplier.getCapacityId());
     ps.setString(4, supplier.getComment());
     ps.setString(5, supplier.getDescription());
     ps.setString (7, day);
     ps.setString (8, day);
     int result = ps.executeUpdate();
     
 } // include supplier
    
    
    public void delete (supplierDO supplier, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "update supplier set deleted=1, deleted_at=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString (1, day);
     int result = ps.executeUpdate();
     
 } // include supplier
    
    
    public Vector getSuppliers(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from supplier where deleted=0";
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
        
        // contatos
        
        Vector contacts = new Vector();
        String sql1 = "select * from contact where contact_supplier_id=?";
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
        }
        //fecha contatos
        
        //endereços
        Vector Addresses = new Vector();
        String sql2 = "select * from supplier_address where supplier_address_id=? ";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setInt(1, s.getId());
        ResultSet rs2 = ps1.executeQuery();
        while (rs2.next()){
            supplierAddressDO sa = new supplierAddressDO();
            sa.setComplement(rs2.getString("supplier_address_complement"));
            sa.setPostalcode(rs2.getString("supplier_address_postalcode"));
            sa.setStreet(rs2.getString("supplier_address_street"));
            sa.setState(rs2.getString("supplier_address_state"));
            sa.setCountry(rs2.getString("supplier_address_country"));
            sa.setSupplier(rs2.getInt("supplier_address_id"));
            sa.setId(rs2.getInt("id"));
        }
        // fecha endereços
        
        //bankInfos
        Vector bankInfos = new Vector();
        String sql3 = "select * from bank_info where bank_info_supplier_id=?";
        PreparedStatement ps3 = con.prepareStatement(sql3);
        ps3.setInt(1,s.getId());
        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()){
            BankInfoDO sa = new BankInfoDO();
            sa.setCnpjCpf(rs3.getString("bank_info_cnpj_cpf"));
            sa.setAccount(rs3.getString("bank_info_account"));
            sa.setAgency(rs3.getString("bank_info_agency"));
            sa.setBankNumber(rs3.getString("bank_info_number"));
            sa.setSupplierId(rs3.getInt("bank_info_supplier_id"));
            sa.setId(rs3.getInt("id"));
        }
        // fecha bankInfos
        
        //materiais
        String[] materials;
        String sql4 = "select m.material_name from supplier_material_relation r inner join material m on m.id=r.material_id where r.supplier_id = ?";
        PreparedStatement ps4 = con.prepareStatement(sql4);
        ps4.setInt(1,s.getId());
        ResultSet rs4 = ps4.executeQuery();
        int i=0;
        while(rs4.next()){
           s.setMaterials(i,rs4.getString("material_name"));
        }
        suppliers.add(s);
     }
     return suppliers;
  } // gets suppliers
    
}
