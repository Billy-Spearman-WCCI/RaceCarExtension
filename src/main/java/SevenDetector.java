public class SevenDetector {
    private STATE state = STATE.NO7;

    public STATE state() {
        return this.state;
    }

    //    public void accept(int i) {
//        if (i == 7) {
//            if (state == STATE.NO7) {
//                state = STATE.ONE7;
//            } else if (state == STATE.ONE7 || state == STATE.TWO7) {
//                state = STATE.SUCCESS;
//            }
//        } else {
//            if (state == STATE.ONE7) {
//                state = STATE.TWO7;
//            } else if (state == STATE.TWO7) {
//                state = STATE.NO7;
//            }
//        }
//    }
    public void accept(int i) {
        switch (state) {
            case NO7:
                if (i == 7)
                    state = STATE.ONE7;
                break;
            case ONE7:
                if (i == 7)
                    state = STATE.SUCCESS;
                else
                    state = STATE.TWO7;
                break;
            case TWO7:
                if (i == 7)
                    state = STATE.SUCCESS;
                else
                    state = STATE.NO7;
                break;
        }
    }

    public void noMoreData() {
        if (state != STATE.SUCCESS)
            state = STATE.FAILURE;
    }

    public enum STATE {NO7, ONE7, TWO7, SUCCESS, FAILURE}
}
