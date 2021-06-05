package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {
//        Emploee emploee1 = new Emploee("Bob", "Wilson", " ••••• ", "Lamberjack",
//                "Bob@sdgm.fg", 123123123, 12300, 25);
//        emploee1.EmploeeInfo();
//    }
               Emploee [] arrEmp = new Emploee[5];
               arrEmp[0] = new Emploee("Tom", "ho", "•••••", "Driver", "sdg@sdf.fd",
                       1654846351, 135468312, 55);
               arrEmp[1] = new Emploee("Tom", "ho", "•••••", "Pilot", "sdg@dg.bg",
                       1654846351, 135468312, 45);
               arrEmp[2] = new Emploee("Tom", "ho", "•••••", "Delivery", "sdg@sg.nh",
                1654846351, 135468312, 41);
               arrEmp[3] = new Emploee("Tom", "ho", "•••••", "Driver", "sdg@sfg.bg",
                1654846351, 135468312, 40);
               arrEmp[4] = new Emploee("Tom", "ho", "•••••", "Lamberjack", "sdg@sfg.ew",
                1654846351, 135468312, 37);
               arrEmp[0].EmploeeInfo();

//       arrEmp[0].AgeChange(70);

//        for (Emploee emploee : arrEmp){
//            if (emploee.GetAge() > 40) {
//                emploee.EmploeeInfo();
//            }
//        }

//        for (int i = 0; i < arrEmp.length; i++){  (Метод if Age > 40, если поменять право доступа с private на
//            if  (arrEmp[i].Age > 40){                   public в поле Age)
//                arrEmp[i].EmploeeInfo();
//            }

        }





    }






