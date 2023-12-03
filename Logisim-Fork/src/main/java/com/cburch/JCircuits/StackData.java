package com.cburch.JCircuits;

import java.util.Stack;

import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstanceState;

public class StackData implements InstanceData, Cloneable {
    private static BitWidth BIT_WIDTH = BitWidth.create(16); 
    private Value lastClock;

    private Stack<Integer> stack;
    private boolean halt = false;

    public static StackData get(InstanceState state) {
		StackData ret = (StackData) state.getData();
		if (ret == null) {
			ret = new StackData();
			state.setData(ret);
		}

		return ret;
	}

    private StackData() {
		this.lastClock = null;
        this.stack = new Stack<>();
	}

    @Override
    public Object clone() {
        try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
    }

    public boolean updateClock(Value value) {
		Value old = lastClock;
		lastClock = value;
		return old == Value.FALSE && value == Value.TRUE;
	}

    public Value getNext() {
        if (stack.size() > 1) {
            Integer top = stack.pop();
            Value ret = Value.createKnown(BIT_WIDTH, stack.peek());
            stack.push(top);
            return ret;
        }

        return Value.createUnknown(BIT_WIDTH);
    }
    public Value getTop() {
        if (stack.size() > 0) {
            return Value.createKnown(BIT_WIDTH, stack.peek());
        }

        return Value.createUnknown(BIT_WIDTH);
    }
    public Value getSize() { return Value.createKnown(BIT_WIDTH, stack.size()); }
    public Value getHalt() {
        return Value.createKnown(BitWidth.create(1), halt ? 1 : 0);
    }

    public void action(InstanceState state) {
        if (halt) {
            return;
        }

        Value dataIn = state.getPort(0);
        Value push = state.getPort(1);
        Value pop = state.getPort(2);
        Value swap = state.getPort(3);

        if (push == Value.TRUE) {
            stack.push(dataIn.toIntValue());
        }

        if (pop == Value.TRUE) {
            if (!stack.empty()) {
                stack.pop();
            } else {
                halt = true;
            }
        }

        if (swap == Value.TRUE) {
            if (stack.size() > 1) {
                Integer top = stack.pop();
                Integer next = stack.pop();
                stack.push(top);
                stack.push(next);
            } else {
                halt = true;
            }
        }
    }
}
