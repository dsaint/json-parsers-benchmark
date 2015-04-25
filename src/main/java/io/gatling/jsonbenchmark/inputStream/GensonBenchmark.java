package io.gatling.jsonbenchmark.inputStream;

import com.owlike.genson.Genson;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.gatling.jsonbenchmark.bytes.Buffers;

/**
 * Created by mmidboe on 4/25/15.
 */
public class GensonBenchmark {

    private static final Genson GENSON = new Genson();

    private Object parse(InputStream inputStream) throws Exception {

        try {
            return GENSON.deserialize(new InputStreamReader(inputStream), Map.class);
        } finally {
            inputStream.close();
        }
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.ACTION_LABEL_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.CITM_CATALOG_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.MEDIUM_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.MENU_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.SGML_BYTES)));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {

        bh.consume(parse(new ByteArrayInputStream(Buffers.WEBXML_BYTES)));

    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(new ByteArrayInputStream(Buffers.WIDGET_BYTES)));

    }

}
