package org.xblackcat.idea.favorites;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @author xBlackCat
 */

@State(
        name = "FavoriteFolders",
        storages = {
                @Storage(
                        id = "other",
                        file = "$APP_CONFIG$/favoriteFolders.xml"
                )
        }
)
public class FavoriteFoldersPlugin extends AFavoritesContainer implements ApplicationComponent {
    private static final Logger LOG = Logger.getInstance("#org.xblackcat.idea.favorites.FavoriteFoldersPlugin");

    public FavoriteFoldersPlugin() {
    }

    @NotNull
    public String getComponentName() {
        return "FavoriteFoldersPlugin";
    }

    @Override
    protected void updateFavorites(boolean firstRun) {
        Utils.reregisterFavorites(this, firstRun);
    }

}
