package io.gatling.jsonbenchmark.string;

import com.owlike.genson.Genson;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.logic.BlackHole;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.gatling.jsonbenchmark.bytes.Buffers.STR_ACTION_LABEL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_CITM_CATALOG_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_MEDIUM_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_MENU_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_SGML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_SMALL_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_WEBXML_BYTES;
import static io.gatling.jsonbenchmark.bytes.Buffers.STR_WIDGET_BYTES;

/**
 * Created by mmidboe on 4/25/15.
 */
public class GensonBenchmark {

    private static final Genson GENSON = new Genson();

    private Object parse(String str) throws Exception {
        return GENSON.deserialize(str, Map.class);
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void actionLabel(BlackHole bh) throws Exception {
        bh.consume(parse(STR_ACTION_LABEL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void citmCatalog(BlackHole bh) throws Exception {
        bh.consume(parse(STR_CITM_CATALOG_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void medium(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MEDIUM_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void menu(BlackHole bh) throws Exception {
        bh.consume(parse(STR_MENU_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void sgml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SGML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void small(BlackHole bh) throws Exception {
        bh.consume(parse(STR_SMALL_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void webxml(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WEBXML_BYTES));
    }

    @GenerateMicroBenchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void widget(BlackHole bh) throws Exception {
        bh.consume(parse(STR_WIDGET_BYTES));
    }
}
