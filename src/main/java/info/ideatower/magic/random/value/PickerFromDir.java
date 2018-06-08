package info.ideatower.magic.random.value;

import info.ideatower.magic.util.DirectoryLoader;

public class PickerFromDir extends Picker<String> {

    public PickerFromDir(String mark, String dirname) {
        super(mark, DirectoryLoader.loadExternalResource(dirname));
    }
}
