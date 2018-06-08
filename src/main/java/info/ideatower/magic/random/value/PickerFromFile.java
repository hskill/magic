package info.ideatower.magic.random.value;

import info.ideatower.magic.util.FileLoader;
import lombok.Data;

@Data
public class PickerFromFile extends Picker<String> {

    public PickerFromFile(String mark, String filename) {
        super(mark, FileLoader.loadExternalResource(filename));

    }
}
