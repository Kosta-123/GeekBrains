package Lesson5;

public class Emploee {

            private String FirstName;
            private String LastName;
            private String MiddleName;
            private String Positiion;
            private String Email;
            private int PhoneNumber;
            private int Salary;
            private int Age;

            public Emploee(String FirstName, String LastName, String MiddleName, String Position, String Email,
                           int PhoneNumber, int Salary, int Age){
                this.FirstName = FirstName;
                this.LastName = LastName;
                this.MiddleName = MiddleName;
                this.Positiion = Position;
                this.Email = Email;
                this.PhoneNumber = PhoneNumber;
                this.Salary = Salary;
                this.Age = Age;
            }

            public void EmploeeInfo() {
                System.out.println("FirstName: " + FirstName + "\n" + "LastName: " + LastName + "\n" +
                        "MiddleName: " + MiddleName + "\n" + "Position: " + Positiion + "\n" +
                        "Email: " + Email + "\n" +  "PhoneNumber: " + PhoneNumber + "\n" + "Salary: " + Salary + "\n" +
                        "Age: " + Age );

            }
            public int GetAge(){
                return Age;
            }



        public void AgeChange(int NewAge) {
                System.out.println("FirstName: " + FirstName + "\n" + "Age: " + Age + "\n" + "NewAge: " + NewAge);
                this.Age = NewAge;
            }

    





    }










