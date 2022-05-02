package models;

public class UserModel {

    public record UserRecord(String Title,
                             String FirstName,
                             String LastName,
                             String Password,
                             String DateOfBirth,
                             String MonthOfBirth,
                             String YearOfBirth,
                             String NewLetterCheckbox,
                             String SpecialOfferCheckbox,
                             String Company,
                             String Address1,
                             String Address2,
                             String City,
                             String State,
                             String Zip,
                             String Additional_Information,
                             String HomePhone,
                             String MobilePhone,
                             String Alias
    )
    {

    }
}
