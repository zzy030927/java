package Program.bookManager.jframe;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;

import Program.bookManager.dao.BorrowDetailDao;
import Program.bookManager.model.BorrowDetail;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AdminBorrowInfo extends JFrame {
    private JFrame jf;
    private JTable table;
    private DefaultTableModel model;
    DbUtils dbUtil=new DbUtils();
    BorrowDetailDao borrowDetailDao=new BorrowDetailDao();
    public AdminBorrowInfo(){
        jf=new JFrame("����Ա����");
        jf.setBounds(400, 100, 610, 441);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        jf.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("������");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("������");
        mntmNewMenuItem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminMenuFrm();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("����޸�");
        mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBTypeEdit();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("�鼮����");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("�鼮���");
        mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBookAdd();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�鼮�޸�");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBookEdit();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_3);

        JMenu menu1 = new JMenu("�û�����");
        menuBar.add(menu1);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("�û���Ϣ");
        mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminUserInfo();
            }
        });
        menu1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("������Ϣ");
        menu1.add(mntmNewMenuItem_5);

        JMenu mnNewMenu_1 = new JMenu("�˳�ϵͳ");
        mnNewMenu_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "��ӭ�ٴ�ʹ��");
                jf.dispose();
            }
        });
        menuBar.add(mnNewMenu_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "������Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel_1.setBounds(10, 10, 574, 350);

        /*��һ����ͷ������  һλ����
         * */
        String[] title={"������","����","״̬","����ʱ��","����ʱ��"};
        /*����ĸ����м�¼ ���ÿյĶ�λ����ռλ*/
        String[][] dates={};
        /*Ȼ��ʵ���� ����2���ؼ�����*/
        model=new DefaultTableModel(dates,title);
        table=new JTable(model);
        putDates(new BorrowDetail());//��ȡ���ݿ����ݷ���table��
        panel_1.setLayout(null);
        JScrollPane jscrollpane = new JScrollPane();
        jscrollpane.setBounds(20, 22, 538, 314);
        jscrollpane.setViewportView(table);
        panel_1.add(jscrollpane);
        jf.getContentPane().add(panel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AdminBorrowInfo.class.getResource("/tupian/adBG2.png")));
        lblNewLabel.setBounds(0, 0, 584, 379);
        jf.getContentPane().add(lblNewLabel);

        jf.setVisible(true);
        jf.setResizable(true);
    }
    private void putDates(BorrowDetail borrowDetail) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            ResultSet list = borrowDetailDao.list(con, borrowDetail);
            while (list.next()) {
                Vector rowData = new Vector();
                rowData.add(list.getString("username"));
                rowData.add(list.getString("book_name"));
                int status = list.getInt("status");
                if (status == 1) {
                    rowData.add("�ڽ�");
                } else {
                    rowData.add("�ѻ�");
                }
                rowData.add(ToolUtils.getDateByTime(list.getLong("borrow_time")));
                if (status == 2) {
                    rowData.add(ToolUtils.getDateByTime(list
                            .getLong("return_time")));
                }
                model.addRow(rowData);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                DbUtils.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AdminBorrowInfo();
    }
}
