package gui;

import backend.UsageAggregator;
import com.intellij.usages.Usage;
import com.intellij.usages.UsageGroup;
import com.intellij.usages.UsageTarget;
import com.intellij.usages.rules.SingleParentUsageGroupingRule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UniqueGroupingRule extends SingleParentUsageGroupingRule {


    UsageAggregator usageAggregator = new UsageAggregator();

//    int count;
//    boolean overCount;

    public UniqueGroupingRule() {
        super();
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Nullable
    @Override
    protected UsageGroup getParentGroupFor(@NotNull Usage usage, @NotNull UsageTarget[] targets) {
        // Below comment indicates why we implement this method over the groupUsage method.
//        /**
//         * @deprecated override {@link #getParentGroupFor(Usage, UsageTarget[])} instead
//         */
//        @Deprecated
//        @Override
//        public UsageGroup groupUsage(@NotNull Usage usage) {
//            return getParentGroupFor(usage, UsageTarget.EMPTY_ARRAY);
//        }

//        if (overCount) {
//            return null;
//        }
//        else if (++count > 100) {
//            overCount = true;
////            JBPopupFactory.getInstance().createConfirmation("Do you love me?", () -> {System.out.println("said yes");}, 0);
//            return null; // Give up after 100 usages
//        }

        UsageGroup out = usageAggregator.getAggregateUsage(usage);
        return out;
    }
}
