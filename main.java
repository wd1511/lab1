package lab1;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.*;

import java.io 

.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] arg)throws InterruptedException {
    	String file_name=JOptionPane.showInputDialog("input the file location:");
    	
    	
    	String s="";
    	int i=0;
    	
    	try
        {
          FileInputStream f=new FileInputStream(file_name);
          int b=f.read();
          int flag=0;
          for(i=0;b!=-1;i++)
          {
        	char tmp=(char)b;
            if((tmp>='a' && tmp<='z')|| (tmp>='A' && tmp<='Z')){s=s+tmp;flag=0;}
            else if((tmp==' ' || tmp=='\r' || tmp=='\n' || tmp==',' || tmp=='.' || tmp=='?' || tmp=='!' || tmp=='\'' || tmp=='\"' || tmp==';' || tmp==':') &&(flag==0)){s=s+" ";flag=1;}
            else s=s;
            b=f.read();
          }
          f.close();
        }
        catch(IOException e)
        { 
          System.err.println("�����쳣��"+e);
          e.printStackTrace();
        }
    	
    	s=s.toLowerCase();
    	System.out.println(s);
    	String []a=s.split(" ");
    	//for(int j=0;j<a.length;j++)System.out.println(a[j]);
    	
    	graph g=new graph();
    	for(int j=0;j<a.length;j++)g.add_node(a[j]);
    	for(int j=0;j<a.length-1;j++)g.add_edge(a[j],a[j+1]);
    	
    	System.out.println(g.get_num());
    	String matrix = "";
    	for(int k=1;k<=g.get_num();k++){
    		for(int j=1;j<=g.get_num();j++){
	    		matrix=matrix+g.a[k][j]+" ";
    		}
    		matrix=matrix+"\r\n";
    	}
    	byte [] b=matrix.getBytes();
		try
		{
			FileOutputStream out=new FileOutputStream("E:\\eclipse-workspace\\file\\matrix.txt");
			out.write(b);
			out.flush();
			out.close();
		}
		catch(IOException ee)
		{
			System.err.println("�����쳣��"+ee);
			ee.printStackTrace();
		}
    	//g.add_node("jhadsfjkh");
    	//g.print_node();
    	//g.print_edge();
    	
    	
    	showpanel p=new showpanel(g);
    	//System.out.println(g.queryBridgeWords("a", "c"));
    	/*String choose="100";
    	int end=1;
    	choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    	while(!choose.equals("0")){
    		//choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		if(choose.equals("1")){
    			
    			dpic d = new dpic();
    			d.showDirectedGraph(g);
    			String choose1=JOptionPane.showInputDialog("�Ƿ�رգ�");
    			if(choose1.equals("��")){
    				d.close();
    			}
    			choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		}
    		
    		else if(choose.equals("2")){
    			String ss=JOptionPane.showInputDialog("�������������ʣ�\n");
    			String []stmp=ss.split(" ");
    			String bridge=g.queryBridgeWords(stmp[0],stmp[1]);
    			if(bridge==null){
    				//System.out.println("û���ŽӴʣ�");
    				JOptionPane.showMessageDialog(null, "û���ŽӴʣ�");
    			}
    			else if(bridge==" "){
    				JOptionPane.showMessageDialog(null,"û��word1����word2");
    			}
    			else{
    				//System.out.println(bridge);
    				JOptionPane.showMessageDialog(null, "�ŽӴ�Ϊ��\n"+bridge);
    			}
    			choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		}
    		
    		else if(choose.equals("3")){
    			String input_text=JOptionPane.showInputDialog("�����ı���\n");
    			String rst=g.generateNewText(input_text);
    			JOptionPane.showMessageDialog(null,rst);
    			choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		}
    		
    		else if(choose.equals("4")){
    			dpath d=new dpath();
    			d.showDirectedGraph(g);
    			String choose1=JOptionPane.showInputDialog("�Ƿ�رգ�");
    			if(choose1.equals("��")){
    				d.close();
    			}
    			choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		}
    		
    		else if(choose.equals("5")){
    			drandom d = new drandom();
    			d.showDirectedGraph(g); 
    			choose=JOptionPane.showInputDialog("��ѡ���ܣ�\n0.�˳�\n1.չʾ����ͼ\n2.��ѯ�ŽӴ�\n3.�����ŽӴ��������ı�\n4.������������֮������·��\n5.�������\n");
    		}
    		else if(choose.equals("0")){
    			System.exit(0);
    		}
    	}*/
    	
    	
    	
    	//System.out.println(bb);
    	
    	//g.floyd();
    	//g.distance(1, 3);
    	//g.path(1, 3);
    	
    	//System.out.println("ok");
    	
    	//System.out.println(g.randomwalk());
    	//System.out.println(x);
    	//dpic d = new dpic(g);
    	//System.exit(0);
    }

}
