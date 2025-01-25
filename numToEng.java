public class numToEng {
    private int num;
    private String sNum;
    private String eng;
    public numToEng(int num){
        this.num = num;
        numToString();
        checkNum();
        checkLength();
    }

    public void numToString(){
        sNum = String.valueOf(num);
    }

    public void checkNum(){
        if (!(0 <= num && num <=999)){
            System.out.println("Please input a digit between 0 to 999 inclusive.");
        }
    }

    public void checkLength(){
        if (sNum.length() == 1){
            eng = singleDigit(sNum);
            System.out.println(eng);
        }
        else if (sNum.length() == 2){
            twoDig(sNum);
        }
        else if (sNum.length() == 3){
            threeDig(sNum);
        }
    }

    public void twoDig(String twoDig){
        if (sNum.substring(0,1).equals("2") || sNum.substring(0,1).equals("3") || sNum.substring(0,1).equals("4") || sNum.substring(0,1).equals("5") || sNum.substring(0,1).equals("6") || sNum.substring(0,1).equals("7") || sNum.substring(0,1).equals("8") || sNum.substring(0,1).equals("9")){
            eng = tens(sNum.substring(0,1)) + singleDigit(sNum.substring(1));
        }
        else if (sNum.substring(0,1).equals("0")) {
            eng = singleDigit(sNum.substring(1));
        }
        else if (sNum.substring(0,1).equals("1")){
            eng = specialTens(sNum);
        }
        System.out.println(eng);
    }

    public void threeDig(String threeDig){
        if(sNum.substring(1).equals("00")){
            eng = hundreds(sNum.substring(0,1));
        }
        else if(sNum.substring(0,1).equals("0")) {
            twoDig(sNum.substring(1));
        }
        else if(sNum.substring(1,2).equals("0")){
            eng = hundreds(sNum.substring(0,1)) + singleDigit(sNum.substring(2));
        }
        else if (sNum.substring(2).equals("0")){
            eng = hundreds(sNum.substring(0,1)) + tens(sNum.substring(2,3));
        }
        else if (sNum.substring(1,2).equals("1")){
            eng = hundreds(sNum.substring(0,1)) + specialTens(sNum.substring(1,3));
        }
        else {
            eng = hundreds(sNum.substring(0,1) + tens(sNum.substring(1,2)) + singleDigit(sNum.substring(2)));
        }
        System.out.println(eng);
    }



    public String singleDigit(String sDigit){
        String singleEng = "";
        if (sDigit.equals("1")){
            singleEng = "one";
        } else if (sDigit.equals("2")){
            singleEng = "two";
        } else if (sDigit.equals("3")){
            singleEng = "three";
        } else if (sDigit.equals("4")){
            singleEng = "four";
        }else if (sDigit.equals("5")){
            singleEng = "five";
        }else if (sDigit.equals("6")){
            singleEng = "six";
        }else if (sDigit.equals("7")){
            singleEng = "seven";
        }else if (sDigit.equals("8")){
            singleEng = "eight";
        }else if (sDigit.equals("9")){
            singleEng = "nine";
        }else if (sDigit.equals("0")){
            singleEng = "zero";
        }
        return singleEng;
    }

    public String tens(String tens){
        String tensEng = "";
        if (tens.equals("1")){
            tensEng = "[Invalid. Please call method specialDoubleDigit instead]";
        } else if (tens.equals("2")){
            tensEng = "twenty";
        } else if (tens.equals("3")){
            tensEng = "thirty";
        } else if (tens.equals("4")) {
            tensEng = "forty";
        } else if (tens.equals("5")) {
            tensEng = "fifty";
        } else if (tens.equals("6")){
            tensEng = "sixty";
        } else if (tens.equals("7")) {
            tensEng = "seventy";
        } else if (tens.equals("8")) {
            tensEng = "eighty";
        } else if (tens.equals("9")){
            tensEng = "ninety";
        } else if (tens.equals("0")){
            tensEng = "";
        }

        return tensEng;
    }

    public String specialTens(String STens){
        String sTensEng = "";
        if (STens.equals("10")){
            sTensEng = "ten";
        } else if (STens.equals("11")) {
            STens = "eleven";
        } else if (STens.equals("12")) {
            STens = "twelve";
        } else if (STens.equals("13")){
            STens = "thirteen";
        } else if (STens.equals("14")){
            STens = "fourteen";
        } else if (STens.equals("15")) {
            STens = "fifteen";
        } else if (STens.equals("16")){
            STens = "sixteen";
        } else if (STens.equals("17")) {
            STens = "seventeen";
        } else if (STens.equals("18")){
            STens = "eighteen";
        } else if (STens.equals("19")){
            STens = "nineteen";
        }
        return sTensEng;
    }

    public String hundreds(String hundreds){
        String hundEng = "";
            hundEng = singleDigit(hundreds) + "hundred";
            return hundEng;
    }
}
