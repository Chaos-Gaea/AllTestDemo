package lyp.com.text.RXJava;

/**
 * Created by lyp on 2019/3/6.
 */

public class Translation {
    private int status;

    private Content content;

   private static class Content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private String ciba_use;
        private String xinyi;
//        private String nut;
        private String ciba_out;
        private int err_no;

        @Override
        public String toString() {
            return "Content{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", vendor='" + vendor + '\'' +
                    ", nut='" + ciba_out + '\'' +
                    ", err_on=" + err_no +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Translation{" +
                "status=" + status +
                '}';
    }

        public void show(){
        System.out.println("RxJava翻译结果"+status);
        System.out.println("RxJava翻译结果"+content.from);
        System.out.println("RxJava翻译结果"+content.to);
        System.out.println("RxJava翻译结果"+content.vendor);
        System.out.println("RxJava翻译结果"+content.ciba_out);
        System.out.println("RxJava翻译结果"+content.out);
        System.out.println("RxJava翻译结果"+content.xinyi);
        System.out.println("RxJava翻译结果"+content.ciba_use);
        System.out.println("RxJava翻译结果"+content.err_no);
    }
}
