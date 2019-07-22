package yip.guesswhoihate;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreHelper {



    private static final String PREF_WIN = "pref_win";
    private static final String PREF_FAIL = "pref_fail";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(
                PREF_WIN, Context.MODE_PRIVATE);
    }

    public static int getWinScore(Context context) {
        return getPreferences(context).getInt(PREF_WIN, 0);

    }

    public static int getFailScore(Context context) {
        return getPreferences(context).getInt(PREF_FAIL, 0);

    }


    public static void addWinScore(Context context) {
        int current_score = getPreferences(context).getInt(PREF_WIN, 0);

        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(PREF_WIN, current_score++);
        editor.apply();
    }

    public static void addFailScore(Context context) {
        int current_score = getPreferences(context).getInt(PREF_FAIL, 0);

        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(PREF_FAIL, current_score++);
        editor.apply();
    }

}
