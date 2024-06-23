/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.RaceTeamDAO;
import controller.EntryDAO;

import model.Entry;
import model.Contract;
import model.RaceTeam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Delar
 */
public class SelectRaceTeamFrm extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form SelectRTFrm
     */
    private Entry entry;
    SelectRaceTeamFrm mainFrm = this;

    
    public SelectRaceTeamFrm(Entry entry) {
        initComponents();
        this.entry = entry;
        
        RaceTeamDAO raceTeamDAO = new RaceTeamDAO();
        ArrayList<RaceTeam> listRaceTeam = raceTeamDAO.getListRaceTeam();
        
        String[][] data = new String[listRaceTeam.size()][3];
        String[] columNames = {"STT", "Đội đua", "Hãng"};
        
        for(int i = 0; i < listRaceTeam.size(); i++){
            data[i][0] = i + 1 + "";
            data[i][1] = listRaceTeam.get(i).getName();
            data[i][2] = listRaceTeam.get(i).getBrand();
        }
        
        DefaultTableModel dtm = new DefaultTableModel(data, columNames);
                
        tblRaceTeam.setModel(dtm);    
        
        ListSelectionModel selectionModel = tblRaceTeam.getSelectionModel();
        
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    
                    int selectedRow = tblRaceTeam.getSelectedRow();
                    

                    
                    EntryDAO entryDAO = new EntryDAO();
                    String status = entryDAO.checExistskEntry(listRaceTeam.get(selectedRow).getId(), entry.getGrandPrix().getID());
                    
                    Contract contract = new Contract();
                    contract.setRaceTeam(listRaceTeam.get(selectedRow));
                    mainFrm.entry.setContract(contract);
                    (new SelectDriverFrm(mainFrm.entry)).setVisible(true);
                    mainFrm.dispose();

//                    if(status.equals("success")){
//                        
//                        Contract contract = new Contract();
//                        contract.setRaceTeam(listRaceTeam.get(selectedRow));
//                        mainFrm.entry.setContract(contract);
//                        (new SelectDriverFrm(mainFrm.entry)).setVisible(true);
//                        mainFrm.dispose();
//                    } 
//                    else {
////                        JOptionPane.showMessageDialog(mainFrm, status);
//                        int result = JOptionPane.showOptionDialog(
//                            mainFrm,                        // Không thiết lập giao diện người dùng cha
//                            status + ".\n Bạn có muốn thay đổi bản đăng ký thi đấu không?" ,     // Nội dung của hộp thoại
//                            "Thông báo",                   // Tiêu đề của hộp thoại
//                            JOptionPane.YES_NO_OPTION,   // Loại hộp thoại (YES_NO_OPTION để có 2 nút Yes và No)
//                            JOptionPane.QUESTION_MESSAGE, // Loại thông báo (QUESTION_MESSAGE để hiển thị biểu tượng câu hỏi)
//                            null,                        // Không sử dụng icon
//                            null,                        // Không sử dụng tùy chọn khác
//                            null                         // Không thiết lập giá trị mặc định
//                        );
//
//                        // Kiểm tra lựa chọn của người dùng
//                        switch (result) {
//                            case JOptionPane.YES_OPTION:
//                                Contract contract = new Contract();
//                                contract.setRaceTeam(listRaceTeam.get(selectedRow));
//                                mainFrm.entry.setContract(contract);
//                                (new SelectDriverFrm(mainFrm.entry)).setVisible(true);
//                                mainFrm.dispose();
//                                break;
//                        // Xử lý khi người dùng chọn No
//                            case JOptionPane.NO_OPTION:
//                                break;
//                        // Xử lý khi người dùng đóng hộp thoại
//                            default:
//                                break;
//                        }
//                    }
                }
            }
        });
        
        tblRaceTeam.getColumnModel().getColumn(0).setMaxWidth(40);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRaceTeam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("SelectRaceTeam");

        tblRaceTeam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Đội đua", "Hãng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRaceTeam.setShowGrid(true);
        jScrollPane1.setViewportView(tblRaceTeam);
        if (tblRaceTeam.getColumnModel().getColumnCount() > 0) {
            tblRaceTeam.getColumnModel().getColumn(0).setMinWidth(50);
            tblRaceTeam.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblRaceTeam.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRaceTeam;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
