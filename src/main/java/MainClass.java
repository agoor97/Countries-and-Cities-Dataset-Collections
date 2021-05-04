import java.util.*;
import java.io.*;

public class MainClass
{
    // this Function reads all Cities from Cities File
    public static void readAllCities()
    {
        System.out.println("================= Read ALL Cities =====================");
        ExcThree three = new ExcThree();
        List<String> citiesReading = three.readCitiesFile("Cities.txt");
        citiesReading.forEach(System.out::println);

    }

    // this Function reads all Countries from Countries File
    public static void readAllCountries()
    {
        System.out.println("================= Read ALL Countries =====================");
        ExcThree three = new ExcThree();
        List<String> countriesReading = three.readCountriesFile("Countries.txt");
        countriesReading.forEach(System.out::println);


    }

    // this Function reads all Countries and its Cities
    public static void readAllCitiesOfEachCountry()
    {
        System.out.println("=============== Read ALL Cities of Country ==================");
        ExcThree three = new ExcThree();
        three.getCountryCities("Countries.txt","Cities.txt");

    }

    // this Function read ALL Cities with its Population sorted by Population
    public static void sortPopulation()
    {
        System.out.println("==== Read ALL Cities with its Population sorted by Population =====");
        ExcThree three = new ExcThree();
        // Here I pass the Code of  EGY as code
        three.getAndSortCitiesPopulation("Cities.txt" , "EGY");

    }

    // this Function get Highest Population of each Country
    public static void getHighestPopulation()
    {
        System.out.println("============ Get Highest Population of each Country ============");
        ExcThree three = new ExcThree();
        three.getHighestPopulationCityOfEachCountry("Countries.txt","Cities.txt");
    }



    public static void main(String[] args)
    {
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");
        System.out.println("");

        readAllCities();

        System.out.println("");
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");

        readAllCountries();

        System.out.println("");
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");

        readAllCitiesOfEachCountry();

        System.out.println("");
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");

        sortPopulation();

        System.out.println("");
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");

        getHighestPopulation();

        System.out.println("");
        System.out.println("=============== Code By MOHAMMED AGOOR ==================");

    }
}
