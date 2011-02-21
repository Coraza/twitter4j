/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.api;

import twitter4j.Paging;

/**
 * @author Joern Huxhorn - jhuxhorn at googlemail.com
 */
public interface ListMethodsAsync {
    /**
     * Creates a new list for the authenticated user. Accounts are limited to 20 lists.
     * <br>This method calls http://api.twitter.com/1/user/lists.json
     *
     * @param listName     The name of the list you are creating. Required.
     * @param isPublicList set true if you wish to make a public list
     * @param description  The description of the list you are creating. Optional.
     * @see <a href="http://dev.twitter.com/doc/post/:user/lists">POST :user/lists | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void createUserList(String listName, boolean isPublicList, String description);

    /**
     * Updates the specified list.
     * <br>This method calls http://api.twitter.com/1/:user/lists/:id.json
     *
     * @param listId         The id of the list to update.
     * @param newListName    What you'd like to change the list's name to.
     * @param isPublicList   Whether your list is public or private. Optional. Values can be public or private. Lists are public by default if no mode is specified.
     * @param newDescription What you'd like to change the list description to.
     * @see <a href="http://dev.twitter.com/doc/post/:user/lists/:id">POST :user/lists/:id | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void updateUserList(int listId, String newListName, boolean isPublicList, String newDescription);

    /**
     * List the lists of the specified user. Private lists will be included if the authenticated users is the same as the user whose lists are being returned.
     * <br>This method calls http://api.twitter.com/1/:user/lists.json
     *
     * @param listOwnerScreenName The screen name of the list owner
     * @param cursor              Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists">GET :user/lists | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void getUserLists(String listOwnerScreenName, long cursor);

    /**
     * Show the specified list. Private lists will only be shown if the authenticated user owns the specified list.
     * <br>This method calls http://api.twitter.com/1/:user/lists/:id.json
     *
     * @param listOwnerScreenName The screen name of the list owner
     * @param id                  The id of the list to show
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists/:id">GET :user/lists/:id | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void showUserList(String listOwnerScreenName, int id);

    /**
     * Deletes the specified list. Must be owned by the authenticated user.
     * <br>This method calls http://api.twitter.com/1/:user/lists/:id.json
     *
     * @param listId The id of the list to delete
     * @see <a href="http://dev.twitter.com/doc/delete/:user/lists/:id">DELETE :user/lists/:id | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void destroyUserList(int listId);

    /**
     * Show tweet timeline for members of the specified list.
     * <br>http://api.twitter.com/1/user/lists/list_id/statuses.json
     *
     * @param listOwnerScreenName The screen name of the list owner
     * @param id                  The id of the list to delete
     * @param paging              controls pagination. Supports since_id, max_id, count and page parameters.
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists/:id/statuses">GET :user/lists/:id/statuses | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void getUserListStatuses(String listOwnerScreenName, int id, Paging paging);

    /**
     * Show tweet timeline for members of the specified list.
     * <br>http://api.twitter.com/1/user/lists/list_id/statuses.json
     *
     * @param listOwnerId The screen name of the list owner
     * @param id          The id of the list to delete
     * @param paging      controls pagination. Supports since_id, max_id, count and page parameters.
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists/:id/statuses">GET :user/lists/:id/statuses | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void getUserListStatuses(long listOwnerId, int id, Paging paging);

    /**
     * List the lists the specified user has been added to.
     * <br>This method calls http://api.twitter.com/1/:user/lists/memberships.json
     *
     * @param listMemberScreenName The screen name of the list member
     * @param cursor               Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists/memberships">GET :user/lists/memberships | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void getUserListMemberships(String listMemberScreenName, long cursor);

    /**
     * List the lists the specified user follows.
     * <br>This method calls http://api.twitter.com/1/[user]/lists/subscriptions.json
     *
     * @param listOwnerScreenName The screen name of the list owner
     * @param cursor              Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
     * @see <a href="http://dev.twitter.com/doc/get/:user/lists/subscriptions">GET :user/lists/subscriptions | dev.twitter.com</a>
     * @since Twitter4J 2.1.1
     */
    void getUserListSubscriptions(String listOwnerScreenName, long cursor);

    /**
     * Returns all lists the authenticating or specified user subscribes to, including their own.
     * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
     * <br>This method calls http://api.twitter.com/1/lists/all.json
     *
     * @param screenName screen name to look up
     * @since Twitter4J 2.1.9
     */
    void getAllSubscribingUserLists(String screenName);

    /**
     * Returns all lists the authenticating or specified user subscribes to, including their own.
     * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
     * <br>This method calls http://api.twitter.com/1/lists/all.json
     *
     * @param userId user id to look up
     * @since Twitter4J 2.1.9
     */
    void getAllSubscribingUserLists(long userId);
}
