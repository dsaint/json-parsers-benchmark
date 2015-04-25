package io.gatling.jsonbenchmark.serializerTests;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.text.SimpleDateFormat;

/**
 * Created by mmidboe on 4/25/15.
 */
public class GensonSerializerImpl implements DataSerializer {

    private Genson genson= new GensonBuilder().setSkipNull(false).useDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")).create();

    @Override
    public String serialize(Object data) {
        return genson.serialize(data);
    }
}
