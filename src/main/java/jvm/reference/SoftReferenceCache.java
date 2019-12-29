package jvm.reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftReferenceCache {

    Map<String,SoftReference<Object>> cache = new HashMap();
}
