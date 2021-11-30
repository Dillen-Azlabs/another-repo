package sg.ihh.ms.sdms.app.processor;

import org.springframework.stereotype.Component;
import sg.ihh.ms.sdms.app.model.BaseModel;

import java.util.*;

@Component
public class StructuredDataProcessor<T extends BaseModel> implements Comparator<T> {

    public StructuredDataProcessor() {
        // Empty Constructor
    }

    public List<T> processList(List<T> list, String languageCode) {
        Map<String, T> map = new HashMap<>();

        for (T obj : list) {
            BaseModel baseModel = obj;
            String key = baseModel.getUid();
            if (map.containsKey(key)) {

                // replace with expected language Code
                if (baseModel.getLanguageCode().equals(languageCode)) {
                    map.put(key, obj);
                }

            } else {
                map.put(key, obj);
            }
        }

        List<T> outputList = new ArrayList<>(map.values());
        Collections.sort(outputList, this);
        return outputList;
    }

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getOrder(), o2.getOrder());
    }

}
