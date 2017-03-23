package simplifii.framework.utility;

import java.util.Collection;

/**
 * Created by robin on 10/18/16.
 */

public class CollectionUtils {

    public static boolean isEmpty(Collection collection){
        return (collection==null||collection.isEmpty())?true:false;
    }

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

}
