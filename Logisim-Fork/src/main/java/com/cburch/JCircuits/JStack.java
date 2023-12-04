package com.cburch.JCircuits;

import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.util.StringGetter;

public class JStack extends InstanceFactory {
    private int BIT_WIDTH_INTEGER = 16;

    private Port createPort(int dx, int dy, String type, int bits, String tooltip) {
        Port port = new Port(dx, dy, type, bits);
        port.setToolTip(new StringGetter() {
            @Override
            public String get() {
                return tooltip;
            }
        });

        return port;
    }

    public JStack() {
        super("JStack");
        setOffsetBounds(Bounds.create(0, 0, 50, 70));

        setPorts(new Port[] {
                createPort(0, 10, Port.INPUT, BIT_WIDTH_INTEGER, "DATA IN"),
                createPort(0, 20, Port.INPUT, 1, "PUSH"),
                createPort(0, 30, Port.INPUT, 1, "POP"),
                createPort(0, 40, Port.INPUT, 1, "SWAP"),
                createPort(0, 50, Port.INPUT, 1, "SET TOP"),
                createPort(0, 60, Port.INPUT, 1, "SET NEXT"),
                createPort(10, 70, Port.INPUT, 1, "SEL"),
                createPort(20, 70, Port.INPUT, 1, "CLOCK"),
                createPort(50, 10, Port.OUTPUT, BIT_WIDTH_INTEGER, "TOP"),
                createPort(50, 20, Port.OUTPUT, BIT_WIDTH_INTEGER, "NEXT"),
                createPort(50, 30, Port.OUTPUT, BIT_WIDTH_INTEGER, "SIZE"),
                createPort(50, 40, Port.OUTPUT, 1, "HALT")
        });
    }

    @Override
    public void paintInstance(InstancePainter painter) {
        painter.drawRoundRectangle(painter.getBounds(), "JStack");
        painter.drawPort(0);
        painter.drawPort(1);
        painter.drawPort(2);
        painter.drawPort(3);
        painter.drawPort(4);
        painter.drawPort(5);
        painter.drawPort(6);
        painter.drawClock(7, Direction.NORTH);
        painter.drawPort(8);
        painter.drawPort(9);
        painter.drawPort(10);
        painter.drawPort(11);
    }

    @Override
    public void propagate(InstanceState state) {
        Value sel = state.getPort(6);
        Value clock = state.getPort(7);
        
        if (sel == Value.TRUE) {
            return;
        }

        StackData data = StackData.get(state);

        boolean trigger = data.updateClock(clock);
        if (trigger) {
            data.action(state);
        }

        // Set outputs
        state.setPort(8, data.getTop(), 0);
        state.setPort(9, data.getNext(), 0);
        state.setPort(10, data.getSize(), 0);
        state.setPort(11, data.getHalt(), 0);
    }
}
