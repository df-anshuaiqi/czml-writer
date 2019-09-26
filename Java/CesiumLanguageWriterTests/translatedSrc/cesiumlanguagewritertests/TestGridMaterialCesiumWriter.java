package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGridMaterialCesiumWriter extends TestCesiumPropertyWriter<GridMaterialCesiumWriter> {
    @Test
    public final void testWriteGridMaterial() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    PolylineCesiumWriter polyline = getPacket().openPolylineProperty();
                    try {
                        {
                            PolylineMaterialCesiumWriter material = polyline.openMaterialProperty();
                            try {
                                {
                                    GridMaterialCesiumWriter gridMaterial = material.openGridProperty();
                                    try {
                                        gridMaterial.writeColorProperty(Color.RED);
                                        gridMaterial.writeCellAlphaProperty(0.7);
                                        gridMaterial.writeLineCountProperty(6D, 3D);
                                        gridMaterial.writeLineThicknessProperty(3D, 4D);
                                        gridMaterial.writeLineOffsetProperty(5D, 9D);
                                    } finally {
                                        DisposeHelper.dispose(gridMaterial);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(material);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polyline);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert
                .assertEquals(
                        "{\"polyline\":{\"material\":{\"grid\":{\"color\":{\"rgba\":[255,0,0,255]},\"cellAlpha\":0.7,\"lineCount\":{\"cartesian2\":[6,3]},\"lineThickness\":{\"cartesian2\":[3,4]},\"lineOffset\":{\"cartesian2\":[5,9]}}}}}",
                        getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<GridMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new GridMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}