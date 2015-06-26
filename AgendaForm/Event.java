/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ancy
 */
public class Event extends javax.swing.JFrame {
//VARIABLE DECLARATIONS: set up a connection OBJECT called con, a Statement object stmt,
    //a ResultSet object CALLED rs
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    private int ID_OWNER;
    /**
     * Creates new form Event
     */
    public Event() {
        initComponents();
        DoConnect( );
    }

    Event(String event_Windows) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //CONECTING TO THE DATABASE
    public void DoConnect( ) {
        try{
            btnSaveRecord.setEnabled( false );
            btnCancelRecord.setEnabled( false );
            
        //connect to the database
        String host = "jdbc:derby://localhost:1527/Test";
        String uName="app";
        String uPass="admin";
        con = DriverManager.getConnection( host, uName, uPass );
       //EXECUTE SOME SQL AND LOAD THE RECORDS INTO THE RESULTSET
        stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_UPDATABLE );
        String sql = "SELECT * FROM app.EVENTS";
        rs = stmt.executeQuery( sql );
        
        //MOVE THE CURSOR THE FIRST RECORD AND GET THE DATA
        rs.next();        
        int id_col=rs.getInt("ID");
        String ID = Integer.toString(id_col);
        String TITLE= rs.getString("Title");
        String DESCRIPTION = rs.getString("Description");
        
       // boolean DATE= rs.getString("Date");
        
        //DISPLAY THE FIRST RECORD IN THE TEXT FIELD
        textID.setText(ID);
       // textDate.setText(DATE);
        textTitle.setText(TITLE);
        textDescription.setText(DESCRIPTION);
      

    }
        catch ( SQLException err ) {
           JOptionPane.showMessageDialog(Event.this,err.getMessage());}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        TestPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("TestPU").createEntityManager();
        eventsQuery = java.beans.Beans.isDesignTime() ? null : TestPUEntityManager.createQuery("SELECT e FROM Events e");
        eventsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : eventsQuery.getResultList();
        eventsQuery1 = java.beans.Beans.isDesignTime() ? null : TestPUEntityManager.createQuery("SELECT e FROM Events e");
        eventsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : eventsQuery1.getResultList();
        jPanelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelButoane = new javax.swing.JPanel();
        btnNewRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        btnSaveRecord = new javax.swing.JButton();
        btnCancelRecord = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        jPanelDate = new javax.swing.JPanel();
        textTitle = new javax.swing.JTextField();
        textDescription = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelButoane2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(865, 510));
        setResizable(false);

        jPanelHeader.setBackground(new java.awt.Color(0, 0, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tasks Planner");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("© 2015 Anca Bobes");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Event"));
        jPanel1.setPreferredSize(new java.awt.Dimension(837, 700));

        jPanelButoane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNewRecord.setText("New Event");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        btnDeleteRecord.setText("Delete Event");
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnSaveRecord.setText("Save Event");
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecordActionPerformed(evt);
            }
        });

        btnCancelRecord.setText("Cancel Event");
        btnCancelRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelRecordActionPerformed(evt);
            }
        });

        btnUpdateRecord.setText("Update Event");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButoaneLayout = new javax.swing.GroupLayout(jPanelButoane);
        jPanelButoane.setLayout(jPanelButoaneLayout);
        jPanelButoaneLayout.setHorizontalGroup(
            jPanelButoaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButoaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelButoaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateRecord))
                .addGap(18, 18, 18)
                .addComponent(btnSaveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelRecord)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanelButoaneLayout.setVerticalGroup(
            jPanelButoaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButoaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelButoaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewRecord)
                    .addComponent(btnSaveRecord)
                    .addComponent(btnCancelRecord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteRecord)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTitleActionPerformed(evt);
            }
        });

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Title");

        jLabel3.setText("Description");

        jLabel4.setText("ID");

        javax.swing.GroupLayout jPanelDateLayout = new javax.swing.GroupLayout(jPanelDate);
        jPanelDate.setLayout(jPanelDateLayout);
        jPanelDateLayout.setHorizontalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(textDescription)
                    .addComponent(textID))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanelDateLayout.setVerticalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(55, 55, 55))
        );

        jPanelButoane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButoane2Layout = new javax.swing.GroupLayout(jPanelButoane2);
        jPanelButoane2.setLayout(jPanelButoane2Layout);
        jPanelButoane2Layout.setHorizontalGroup(
            jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButoane2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanelButoane2Layout.setVerticalGroup(
            jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButoane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious))
                .addGap(4, 4, 4)
                .addGroup(jPanelButoane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext))
                .addGap(79, 79, 79))
        );

        jScrollPane1.setRequestFocusEnabled(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, eventsList1, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idOwner}"));
        columnBinding.setColumnName("Id Owner");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelButoane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelButoane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelButoane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelButoane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(328, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
             rs.first( );             
        int id_col=rs.getInt("ID");
        String ID = Integer.toString(id_col);
        String TITLE= rs.getString("Title");
        String DESCRIPTION = rs.getString("Description");
        
         textID.setText(ID);
       // textDate.setText(DATE);
        textTitle.setText(TITLE);
        textDescription.setText(DESCRIPTION);                  
                }
        catch (SQLException err) {
           JOptionPane.showMessageDialog(Event.this, err.getMessage());
                                  }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if ( rs.next( ) ) 
            {
        int id_col=rs.getInt("ID");
        String ID = Integer.toString(id_col);
        String TITLE= rs.getString("Title");
        String DESCRIPTION = rs.getString("Description");
        
         textID.setText(ID);
       // textDate.setText(DATE);
        textTitle.setText(TITLE);
        textDescription.setText(DESCRIPTION);}
            else {
                rs.previous( );
             JOptionPane.showMessageDialog(Event.this, "End of File");
                    }
                }
        catch (SQLException err) {
           JOptionPane.showMessageDialog(Event.this, err.getMessage());
                                  }


    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
         try {
            if ( rs.previous( ) ) 
            {
        int id_col=rs.getInt("ID");
        String ID = Integer.toString(id_col);
        String TITLE= rs.getString("Title");
        String DESCRIPTION = rs.getString("Description");
        
         textID.setText(ID);
       // textDate.setText(DATE);
        textTitle.setText(TITLE);
        textDescription.setText(DESCRIPTION);}
            else {
                rs.previous( );
             JOptionPane.showMessageDialog(Event.this, "Start of file");
                    }
                }
        catch (SQLException err) {
           JOptionPane.showMessageDialog(Event.this, err.getMessage());
                                  }

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
       try {
             rs.last( );             
        int id_col=rs.getInt("ID");
        String ID = Integer.toString(id_col);
        String TITLE= rs.getString("Title");
        String DESCRIPTION = rs.getString("Description");
        
         textID.setText(ID);
       // textDate.setText(DATE);
        textTitle.setText(TITLE);
        textDescription.setText(DESCRIPTION);                  
                }
        catch (SQLException err) {
           JOptionPane.showMessageDialog(Event.this, err.getMessage());
                                  }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed
        
        String ID = textID.getText();
        String TITLE= textTitle.getText();
        String DESCRIPTION = textDescription.getText();
        
        int newID = Integer.parseInt( ID );
        try {
               rs.updateInt( "ID", newID );
               rs.updateString( "TITLE", TITLE );
               rs.updateString( "DESCRIPTION", DESCRIPTION );
               rs.updateRow( );
            JOptionPane.showMessageDialog(Event.this, "Updated");
            }
            catch (SQLException err) {
              System.out.println(err.getMessage() );
                                        }
    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed
       try{
           curRow = rs.getRow( );
           textID.setText("");
          // textDate.setText(DATE);
           textTitle.setText("");
           textDescription.setText("");
           btnFirst.setEnabled( false );
           btnPrevious.setEnabled( false ) ;
            btnNext.setEnabled( false );
           btnLast.setEnabled( false );
           btnUpdateRecord.setEnabled( false );
           btnDeleteRecord.setEnabled( false );
           btnNewRecord.setEnabled( false );

           btnSaveRecord.setEnabled( true );
           btnCancelRecord.setEnabled( true );
       }catch (SQLException err) {
              System.out.println(err.getMessage() );
                                        }
    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnCancelRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelRecordActionPerformed
        try{
            //we need to get the row that was previously loaded and put the data back
            //ABSOLUTE method moves the cursor back to the row it was previously pointing to
            rs.absolute( curRow );
            textTitle.setText( rs.getString("Title") );
            textDescription.setText( rs.getString("Description") );
            textID.setText(rs.getString("ID"));
            
            btnFirst.setEnabled( true );
            btnPrevious.setEnabled( true ) ;
            btnNext.setEnabled( true );
            btnLast.setEnabled( true );
            btnUpdateRecord.setEnabled( true );
            btnDeleteRecord.setEnabled( true ); 
            btnNewRecord.setEnabled( true );

            btnSaveRecord.setEnabled( false );
            btnCancelRecord.setEnabled( false );
        }catch (SQLException err) {
              System.out.println(err.getMessage() );
        }
    }//GEN-LAST:event_btnCancelRecordActionPerformed

    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed
           
            String TITLE=textTitle.getText();
           // String ID=textIdOwner.getText();
            String ID = textID.getText();
        int newID=Integer.parseInt(ID);
        
            String DESCRIPTION = textDescription.getText();
            
           // int newID=Integer.parseInt(ID);
            
        try{
            rs.moveToInsertRow( );// Insert Row CREATES A BLANK RECORD IN THE ResultSet
            
            rs.updateInt("ID", newID);
            rs.updateString("Title", TITLE);// adding DATA to the ResultSet
            rs.updateString("Description", DESCRIPTION);
            rs.updateInt(ID_OWNER, 1);
                        

            rs.insertRow( ); // INSERT a NEW row
            
            stmt.close( );
            rs.close( );
        
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT ID, TITLE,DESCRIPTION FROM app.EVENTS";
            rs = stmt.executeQuery( sql );
    
    //MOVE THE
    rs.next();
    int id_col=rs.getInt("ID");
    String id = Integer.toString(id_col);
    String TITLE2= rs.getString("Title");
    String DESCRIPTION2 = rs.getString("Descrition");
 
    
    //DISPLAY THE FIRST RECORD IN THE TEXTFIELDS
    textID.setText(id);
    textDescription.setText(DESCRIPTION2);
    textTitle.setText(TITLE2);
    
    
        btnFirst.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        btnUpdateRecord.setEnabled(true);
        btnDeleteRecord.setEnabled(true);
        btnNewRecord.setEnabled(true);
        
        btnSaveRecord.setEnabled(false);
        btnCancelRecord.setEnabled(false);
    //DefaultTableModel model = (DefaultTableModel) emp_table.getModel();
//model.AddRow();   
           }catch ( SQLException err ) {
               JOptionPane.showMessageDialog(Event.this,err.getMessage());
                                        }
       
    }//GEN-LAST:event_btnSaveRecordActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
         try{
            rs.deleteRow( );
            
            stmt.close( );
            rs.close( );
        
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT ID,DESCRIPTION,ID_OWNER,TITLE FROM app.EVENTS";
            rs = stmt.executeQuery( sql );
    
    //MOVE THE
           rs.next();
           int id_col=rs.getInt("ID");
            String id = Integer.toString(id_col);
            String TITLE= rs.getString("Title");
            String DESCRIPTION = rs.getString("Description");
            
   
    
    //DISPLAY THE FIRST RECORD IN THE TEXTFIELDS
           textID.setText(id);
           textTitle.setText(TITLE);
           textDescription.setText(DESCRIPTION);
                  
           }catch ( SQLException err ) {
               JOptionPane.showMessageDialog(Event.this,err.getMessage());}
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void textTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTitleActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager TestPUEntityManager;
    private javax.swing.JButton btnCancelRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JButton btnUpdateRecord;
    private java.util.List<AgendaForm.Events> eventsList;
    private java.util.List<AgendaForm.Events> eventsList1;
    private javax.persistence.Query eventsQuery;
    private javax.persistence.Query eventsQuery1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelButoane;
    private javax.swing.JPanel jPanelButoane2;
    private javax.swing.JPanel jPanelDate;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textDescription;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textTitle;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}