public class Pregunta1 {

    public static String getEventosDiciembre(int day) {
        String msg;
        if (day > 0 && day <= 31) {
            if (day % 2 == 0) {
                msg = "NO HAY EVENTO - dia : " + day;
            } else {
                msg = "EXISTE EVENTO - dia : " + day;
            }
        } else {
            msg = "FECHA INCORRECTA";
        }
        return msg;
    }

    public static void main(String [] args){
      System.out.println(Pregunta1.getEventosDiciembre(0));
        System.out.println(Pregunta1.getEventosDiciembre(1));
        System.out.println(Pregunta1.getEventosDiciembre(29));
        System.out.println(Pregunta1.getEventosDiciembre(2));
        System.out.println(Pregunta1.getEventosDiciembre(31));
        System.out.println(Pregunta1.getEventosDiciembre(32));

    }
}
