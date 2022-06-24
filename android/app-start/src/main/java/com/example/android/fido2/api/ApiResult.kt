/*
 * Copyright 2020 Google Inc. All Rights Reserved.
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

package com.example.android.fido2.api

/**
 * Represents the result of an API call.
 */
sealed class ApiResult<out R> {

    /**
     * API returned successfully with data.
     */
    class Success<T>(
        /**
         * The session ID to be used for the subsequent API calls.
         * Might be null if the API call does not return a new cookie.
         */
        val sessionId: String?,

        /**
         * The result data.
         */
        val data: T
    ) : ApiResult<T>()

    /**
     * API returned unsuccessfully with code 401, and the user should be signed out.
     */
    object SignedOutFromServer : ApiResult<Nothing>()
}
