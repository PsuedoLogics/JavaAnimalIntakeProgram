public class Monkey extends RescueAnimal{

    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    public Monkey(String name, String species, String gender, String age,
               String weight, String tailLength, String height, String bodyLength,  String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

    public void setSpecies(String mSpecies)
    {
        species = mSpecies;
    }
    public String getSpecies()
    {
        return species;
    }
    public void setTailLength(String taillength)
    {
        tailLength = taillength;
    }
    public String getTailLength()
    {
        return tailLength;
    }
    public void setHeight(String mheight)
    {
        height = mheight;
    }
    public String getHeight()
    {
        return height;
    }
    public void setBodyLength(String bodylength)
    {
        bodyLength = bodylength;
    }
    public String getBodyLength()
    {
        return bodyLength;
    }
}
