package io.gatling.jsonbenchmark.bytes;

import com.owlike.genson.Genson;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.ACTION_LABEL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.CITM_CATALOG_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.MEDIUM_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.MENU_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.SGML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.SMALL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.WEBXML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.WIDGET_BYTES;

/**
 * Created by mmidboe on 4/25/15.
 */
public class GensonBenchmark {
    private static final Genson GENSON = new Genson();

    private Object parse(byte[] bytes) throws Exception {
        Reader reader = new InputStreamReader(new ByteArrayInputStream(bytes), StandardCharsets.UTF_8);
        return GENSON.deserialize(reader, Map.class);
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(MENU_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(SGML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(WIDGET_BYTES));
    }

}
