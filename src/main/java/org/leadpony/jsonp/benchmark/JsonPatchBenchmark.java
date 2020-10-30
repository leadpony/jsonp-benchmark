/*
 * Copyright 2019, 2020 the JSON-P Test Suite Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.leadpony.jsonp.benchmark;

import java.util.concurrent.TimeUnit;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonPatch;
import jakarta.json.JsonStructure;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * @author leadpony
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class JsonPatchBenchmark {

    private JsonPatch patch;
    private JsonStructure target;

    @Setup
    public void setUp() {
        JsonArray array = Json.createArrayBuilder()
            .add(Json.createObjectBuilder()
                .add("op",  "add")
                .add("path",  "/baz")
                .add("value", "qux")
                .build())
            .build();
        this.patch = Json.createPatch(array);

        this.target = Json.createObjectBuilder()
            .add("foo", "bar")
            .build();
    }

    @Benchmark
    public JsonStructure apply() {
        return patch.apply(target);
    }

    public static void main(String[] args) {
        JsonPatchBenchmark benchmark = new JsonPatchBenchmark();
        benchmark.setUp();
        benchmark.apply();
    }
}
