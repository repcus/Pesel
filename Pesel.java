public class Pesel {

    private String birthDate;
    private String gender;
    private String pesel;

    public Pesel(String newPesel){
        try{
            this.pesel = newPesel;
            if(Pesel.validate(pesel)){
                //birth date
                if((pesel.charAt(2) == '0') || (pesel.charAt(2) == '1')){
                    this.birthDate = String.format("%s%s.%s%s.19%s%s", pesel.charAt(4), pesel.charAt(5), pesel.charAt(2), pesel.charAt(3), pesel.charAt(0), pesel.charAt(1));
                }else if((pesel.charAt(2) == '8') || (pesel.charAt(2) == '9')){
                    this.birthDate = String.format("%s%s.%s%s.18%s%s", pesel.charAt(4), pesel.charAt(5), pesel.charAt(2) - '8', pesel.charAt(3), pesel.charAt(0), pesel.charAt(1));
                }else if((pesel.charAt(2) == '2') || (pesel.charAt(2) == '3')){
                    this.birthDate = String.format("%s%s.%s%s.20%s%s", pesel.charAt(4), pesel.charAt(5), pesel.charAt(2) - '2', pesel.charAt(3), pesel.charAt(0), pesel.charAt(1));
                }else if((pesel.charAt(2) == '4') || (pesel.charAt(2) == '5')){
                    this.birthDate = String.format("%s%s.%s%s.21%s%s", pesel.charAt(4), pesel.charAt(5), pesel.charAt(2) - '4', pesel.charAt(3), pesel.charAt(0), pesel.charAt(1));
                }else if((pesel.charAt(2) == '6') || (pesel.charAt(2) == '7')){
                    this.birthDate = String.format("%s%s.%s%s.22%s%s", pesel.charAt(4), pesel.charAt(5), pesel.charAt(2) - '6', pesel.charAt(3), pesel.charAt(0), pesel.charAt(1));
                }
                //gender
                if(((int) pesel.charAt(9) % 2) == 0){
                    this.gender = "female";
                }else{
                    this.gender = "male";
                }
            }else{
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            System.out.println("Incorrect pesel number\nProgramme will will shut down");
            System.exit(1);
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPesel() {
        return pesel;
    }

    static Integer charToInt(Character ch){
        return ch - '0';
    }
    public static boolean validate(String pesel) {
        if(pesel.length() != 11){
            return false;
        }
        int checkSum = charToInt(pesel.charAt(0)) * 9 + charToInt(pesel.charAt(1)) * 7 + charToInt(pesel.charAt(2)) * 3 + charToInt(pesel.charAt(3))+ charToInt(pesel.charAt(4)) * 9 + charToInt(pesel.charAt(5)) * 7 + charToInt(pesel.charAt(6)) * 3 + charToInt(pesel.charAt(7)) + charToInt(pesel.charAt(8)) * 9 + charToInt(pesel.charAt(9)) * 7;
        return (checkSum % 10 == charToInt(pesel.charAt(10)));
    }
}
