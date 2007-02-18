/*
 * TableUtil.java
 *
 * Created on 2006/12/31, 17:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.seasar.framework.util.ResourceUtil;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.data.TableData;

/**
 *
 * @author shimura
 */
public class TableUtil {
    
    public static void SetPreferedColumnWIdth(JTable table, int[] widths) {

        for (int i=0; i < widths.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
        }

    }
    	public static void WriteToCsv(TableData td, String fileName, String charsetName){
    		BufferedWriter bw = null;
    		try {
    			if (charsetName != null) {
    				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(fileName), charsetName));
    			} else {
    				bw = new BufferedWriter(new OutputStreamWriter(
    						new FileOutputStream(fileName)));   				
    			}
        		WriteLineSub(td.getColumnIdentifires(), bw);
    			for (int i = 0; i < td.getDataArray().size(); i++) {
    				WriteLineSub((ArrayList)td.getDataArray().get(i), bw);
    			}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	}
    	private static void WriteLineSub(ArrayList row, BufferedWriter bw){
    		StringBuffer sb = new StringBuffer();
    		for(int i=0; i < row.size(); i++){
    			if (i>0) {
    				sb.append(",");
    			}
    			sb.append((String)row.get(i));
    		}
    		try {
				bw.write(sb.toString()+"\r");
				sb = new StringBuffer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	public static void ReadFromCsv(TableData td, String fileName){
    		ReadFromCsv(td, fileName, null);
    	}
    
        public static void ReadFromCsv(TableData td, String fileName, String charsetName)  {
        	InputStreamReader is=null;
        try {
        	if (charsetName != null) {
        		is =new InputStreamReader(new FileInputStream(fileName),charsetName);
        	} else {
        		is =new InputStreamReader(new FileInputStream(fileName));       		
        	}
        	ReadCsvSub(td, is);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    public static void ReadCsvFromResource(TableData td, String path){
    	ReadCsvFromResource(td, path, null);
    }
    
    public static void ReadCsvFromResource(TableData td, String path, String charsetName) {
        // sample ReadCsvFromResource(td, "test.csv", "ms932");
        InputStream is = ResourceUtil.getResourceAsStream(path);
        InputStreamReader ir = null ;
        try {
        	if (charsetName != null) {
        		ir = new InputStreamReader(is, charsetName);
        	} else {
        		ir = new InputStreamReader(is);
        	}
            ReadCsvSub(td, ir);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        finally {

            try {
                ir.close();
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    private static void ReadCsvSub(TableData td, Reader rdr ){

         BufferedReader br = new BufferedReader(rdr);
         String line = null;
        try {
            line = br.readLine();
            String[] hdr = SplitCSVString(line);
            td.setColumnIdentifires(hdr);
            while ((line=br.readLine())!=null) {
                String[] row = SplitCSVString(line);
                td.addRow(row);
            }
            br.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Object[] getNullRow(TableModel tm) {
        Object [] row = new Object[tm.getColumnCount() ];
        return row;
    }
    public static void addNewRow(GolfTableModel tm) {
        tm.addRow(getNullRow(tm));
    }
    
    public static void addNewRowWithItemNo (GolfTableModel tm, int seqColumn, int seqIncremental, int seqDigits ) {
        Object[] row = getNullRow(tm);
        int maxSeq = 0;
        for (int i = 0; i < tm.getRowCount(); i++) {
            String seq = (String) tm.getValueAt(i, seqColumn);
            if (Integer.valueOf(seq) > maxSeq) {
                maxSeq = Integer.valueOf(seq);
            }
        }
        String newSeq = "0000000000"+ String.valueOf(maxSeq  + seqIncremental);
        row[seqColumn] =newSeq.substring(newSeq.length() - seqDigits, newSeq.length() );
        tm.addRow(row);
    }
    public static boolean checkRowDownEvent(KeyEvent evt){
        int keyCode = evt.getKeyCode();
        if ( keyCode == evt.VK_DOWN  || keyCode == evt.VK_TAB || keyCode == evt.VK_ENTER ||
                keyCode == evt.VK_KP_DOWN || keyCode == evt.VK_RIGHT) {   
            return true;
        }  else {
            return false;
        }  
    }

static String[] SplitCSVString( String str )
{
    if ( str == null ) {
        return new String[0];
    } 


    int  pos;   
    int  len;    
    int  last;        
    char ch;          
    boolean quot;       
    ArrayList splitted; 

    pos = 0;
    len = str.length();
    last = 0;
    ch = 0;
    quot = false;
    splitted = new ArrayList();

    while ( pos < len )
    {
        ch = str.charAt(pos);

        if ( !quot && ch == ',' ) 
        {
            addStringToArrayList(last, pos, splitted, str);   
            last = pos + 1;
        }
        else if ( ch == '"' ) 
        {
            quot = !quot;
        }
        pos += 1;
    }
    if ( ch == ',' ) {
        splitted.add( "" );
    } else {
            addStringToArrayList(last, pos, splitted, str);       
    }
    return (String[]) splitted.toArray(new String[0]);
}            

    private static void addStringToArrayList(final int last, final int pos, final ArrayList splitted, final String str) {
        String val = str.substring( last, pos);
        if ((val.length()>0) && (val.charAt(0)=='\"') && (val.charAt(val.length()-1)=='\"'))
        {
            val = val.substring( 1, val.length() - 1 );
        }
        splitted.add( val );       
    }

}
