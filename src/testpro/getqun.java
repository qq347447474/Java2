package testpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

public class getqun {
	 /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost() {
        PrintWriter out = null;
        
        
        
        
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL("http://qun.qq.com/cgi-bin/qun_mgr/search_group_members");
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            //conn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
            conn.setRequestProperty("Cache-Control","max-age=0");
            conn.setRequestProperty("Connection","keep-alive");
            conn.setRequestProperty("Content-Length","46");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Host","qun.qq.com");
            conn.setRequestProperty("Origin","http://qun.qq.com");
            conn.setRequestProperty("Referer","http://qun.qq.com/member.html");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.137 Safari/537.36 LBBROWSER");
            conn.setRequestProperty("X-Requested-With","XMLHttpRequest");
            conn.setRequestProperty("Cookie","qm_username=347447474; qm_sid=9f32145d89d5da0502b196acec39947c,qLUVIUDZxazdnVmtxVzlkZ0N5RTh2WDBzeHNtZ0JXVG9ZQnlYQ09mSVA4a18.; rv2=803EB7112C6AD8255FBE4D8FDC07B6001C8D9349DE95230807; property20=16280FE80989ED62B317A8127A982E3716A2FD54FF154E201AC86D99515123FE58D25442EF38236A; RK=hdnzyVzZdI; o_cookie=347447474; verifysession=h02-8XnTxlW2Tj-HzbuFJmP5YvGxRrI1_RRzEMc8P37svzikiAPXUtkKc3-YHRJYnHvq_zpQ-uBQQyuELlCd_CgSg**; ptui_loginuin=969369625; ptisp=cnc; ptcz=2aef71846f2826d7fc075778641242a1f95a0dffdeeb7c63b58d0c1b656cab2b; pt2gguin=o0969369625; uin=o0969369625; skey=@nRQ0JDGwl; p_uin=o0969369625; p_skey=JytFCZg3HzAH7vtmi3c9oZXdP1oq3GQjahDjPrfl0Ww_; pt4_token=xdYTH2*chQFd37DRhlgYug__; pgv_info=ssid=s9623238200; ts_last=qun.qq.com/member.html; ts_refer=ui.ptlogin2.qq.com/cgi-bin/login; pgv_pvid=8548744532; ts_uid=6291932104");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print("gc=321453473&st=0&end=9999&sort=0&bkn=1130846750");
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = new String(sendPost().getBytes(), "gb2312");
        System.out.println(s);
    	System.out.println(sendPost());
	}
}
