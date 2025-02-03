package helpers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

/**
     * Pide texto para poder devolverlo
     * @return Devuelve el texto dado
     * @throws IOException
     */
    public static String readTheLine(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        }catch(IOException e){
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Pide un numero para poder devolverlo
     * @return Devuelve el numero dado
     * @throws IOException
     */
    public static int readTheNumber(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=0;
        try {
            input = Integer.parseInt(br.readLine());
            return input;
        }catch(IOException e){
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Pide un numero para poder devolverlo
     * @return Devuelve el numero dado
     * @throws IOException
     */
    public static float readTheNumberF(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float input=0;
        try {
            input = Float.parseFloat(br.readLine());
            return input;
        }catch(IOException e){
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void closer(){
        try {
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}