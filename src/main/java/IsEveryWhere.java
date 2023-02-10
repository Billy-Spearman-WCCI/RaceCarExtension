import java.util.Optional;

public class IsEveryWhere {
    public boolean isEverywhere(final int[] nums, final int val) {
        Optional<Integer> rememberedValue = Optional.empty();

        for (final int num : nums) {
            if (rememberedValue.isPresent() && val != num && val != rememberedValue.get()) {
                return false;
            }
            rememberedValue = Optional.of(val);
        }
        return true;
    }

}
