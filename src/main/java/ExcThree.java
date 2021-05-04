import com.sun.source.tree.ContinueTree;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.print.attribute.HashAttributeSet;
import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.*;

public class ExcThree
{

    // this Function returns All list of Cities
    public List<String> readCitiesFile(String fileCities)
    {
        List<String> citiesList = new ArrayList<>();
        BufferedReader bf = null;

        try
        {
            bf= new BufferedReader(new FileReader(fileCities));
            String sCurrentLine;
            while ((sCurrentLine = bf.readLine()) != null)
            {
                citiesList.add(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return citiesList;
    }


    // this Function returns All list of Countries
    public List<String> readCountriesFile(String fileCountries)
    {
        List<String> countriesList = new ArrayList<>();
        BufferedReader bf = null;

        try
        {
            bf= new BufferedReader(new FileReader(fileCountries));
            String sCurrentLine;
            while ((sCurrentLine = bf.readLine()) != null)
            {
                countriesList.add(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return countriesList;
    }


    // this Function returns All Cities of Countries
    public void getCountryCities(String fileCountry , String fileCity)
    {
        Map<String,List<String>> cityForEachCountry = new HashMap<>();
        List<String> readCountry = readCountriesFile(fileCountry);
        List<String> readCity = readCitiesFile(fileCity);

        for (int i = 0; i < readCountry.size() ; i++)
        {
            // Read Code from Country File
            String str1 = readCountry.get(i);
            int y = str1.indexOf(',');
            String codeCountry = str1.substring(0, y);

            // Read Country Name from Country File
            String str2 = readCountry.get(i);
            int x1 = str2.indexOf(',');
            int x2 = str2.indexOf(',', str2.indexOf(',') + 1);
            String nameCountry = str2.substring(x1 + 2, x2);

            cityForEachCountry.put(nameCountry,new ArrayList<>());

            for (int j = 0; j < readCity.size(); j++)
            {
                // Read Code from City File
                String str3 = readCity.get(j);
                int x = str3.lastIndexOf(',');
                String codeFromCity = str3.substring(x+2);

                // Checking the equality of Code from Both City and Country
                if (codeCountry.equals(codeFromCity))
                {
                    String str4 = readCity.get(j);
                    int y1 = str4.indexOf(',');
                    int y2 = str4.indexOf(',', str4.indexOf(',') + 1);
                    String city = str4.substring(y1+2,y2);
                    cityForEachCountry.get(nameCountry).add(city);
                }
            }

        }

        // Looping on the Map to print Key >> its Values
        for (Map.Entry<String, List<String>> entry : cityForEachCountry.entrySet())
        {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println("Cities at ..  " + key + "" + " is  >=   " + values);
        }
    }


    // this Function returns Cities with its Population sorted by Population
    public void getAndSortCitiesPopulation(String fileCity , String countryCode)
    {
        Map<String,String> citiesPopulation = new HashMap<>();
        List<String> returnedCitiesFile = readCitiesFile(fileCity);

        for (int i = 0; i < returnedCitiesFile.size(); i++)
        {
            // Get the Code from city File
            String arr2 = returnedCitiesFile.get(i);
            int x = arr2.lastIndexOf(',');
            String codeFromCity = arr2.substring(x+2);

            // Get the City Name from city File
            String arr3 = returnedCitiesFile.get(i);
            int y1 = arr3.indexOf(',');
            int y2 = arr3.indexOf(',', arr3.indexOf(',') + 1);
            String cityName = arr3.substring(y1+2,y2);

            // Get Population from City File
            String arr4 = returnedCitiesFile.get(i);
            int y3 = arr4.indexOf(',', arr3.indexOf(',') + 1);
            int y4 = arr4.indexOf(',', arr3.indexOf(',') + y3);
            String cityPopulation =  arr3.substring(y3+2,y4);

            if(codeFromCity.equals(countryCode))
            {
                citiesPopulation.put(cityName,cityPopulation);
            }
        }


        Map<String, Integer> newMap =
                citiesPopulation.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Integer.parseInt(entry.getValue())));


        // Sorting HashMap according to Population
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(newMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {


            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String,Integer> item:list)
        {
            System.out.println(item);
        }



    }



    // this Function get The last Index of function(getAndSortCitiesPopulation)
    public void getLstIndexOfSortedPopulation(String fileCity , String countryCode)
    {
        Map<String,String> citiesPopulation = new HashMap<>();
        List<String> returnedCitiesFile = readCitiesFile(fileCity);

        for (int i = 0; i < returnedCitiesFile.size(); i++)
        {
            // Get the Code from city File
            String arr2 = returnedCitiesFile.get(i);
            int x = arr2.lastIndexOf(',');
            String codeFromCity = arr2.substring(x+2);

            // Get the City Name from city File
            String arr3 = returnedCitiesFile.get(i);
            int y1 = arr3.indexOf(',');
            int y2 = arr3.indexOf(',', arr3.indexOf(',') + 1);
            String cityName = arr3.substring(y1+2,y2);

            // Get Population from City File
            String arr4 = returnedCitiesFile.get(i);
            int y3 = arr4.indexOf(',', arr3.indexOf(',') + 1);
            int y4 = arr4.indexOf(',', arr3.indexOf(',') + y3);
            String cityPopulation =  arr3.substring(y3+2,y4);

            if(codeFromCity.equals(countryCode))
            {
                citiesPopulation.put(cityName,cityPopulation);
            }
        }


        Map<String, Integer> newMap =
                citiesPopulation.entrySet().stream().collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> Integer.parseInt(entry.getValue())));


        // Sorting HashMap according to Population
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(newMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {


            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int j = 0;
        for (int i = 0; i <list.size() ; i++)
        {
            if(j == 0)
            {

                System.out.println( "Highest Population City of each Country  >= " +list.toArray()[list.size()-1]);
                j = 1;
                continue;
            }

        }


    }



    // this Function get the Highest Population of each Country
    public void getHighestPopulationCityOfEachCountry(String fileCountry , String fileCity)
    {
        List<String> returnedCounty = readCountriesFile(fileCountry);

        List<String> codeCountriesList = new ArrayList<>();
        for (int i = 0; i < returnedCounty.size(); i++)
        {
            // get Code Country
            String str1 = returnedCounty.get(i);
            int y = str1.indexOf(',');
            String codeCountry = str1.substring(0, y);
            codeCountriesList.add(codeCountry);

        }

        for (int j = 0; j <returnedCounty.size() ; j++)
        {
            getLstIndexOfSortedPopulation(fileCity , codeCountriesList.get(j));

        }


    }



}
