package software.ulpgc.kata2;


public class TsvTitleDeserializer implements TitleDeserializer {

    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Title deserialize(String[] split) {
        return new Title(split[0],split[1],split[2],split[3],split[4], split[5],split[6], split[7],split[8]);
    }

}
