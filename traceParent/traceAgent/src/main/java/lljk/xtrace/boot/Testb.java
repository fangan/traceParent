package lljk.xtrace.boot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2019/3/14 下午8:39
 * @Author fangan
 **/
public class Testb {
    public static void main(String[] args) {
        byte[] b=new byte[]{1};
        bb(b);
    }
    public static void bb(byte[] b){


                BufferedOutputStream bos = null;
                FileOutputStream fos = null;
                File ff = null;
                try {

                    ff = new File("/Users/fangan"+"/"+"AbstractClusterInvoker.class");


                    fos = new FileOutputStream(ff);
                    bos = new BufferedOutputStream(fos);
                    bos.write(b);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bos != null) {
                        try {
                            bos.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
    }
    private void aa(){
        File file = new File("/Users/fangan/AbstractClusterInvoker.class");
        try {
            file.createNewFile();//必须要执行

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
