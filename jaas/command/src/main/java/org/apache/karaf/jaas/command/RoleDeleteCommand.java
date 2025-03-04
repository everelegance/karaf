/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.karaf.jaas.command;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.jaas.modules.BackingEngine;

/**
 * Deletes a role from a user of the active realm/module.
 */
@Command(scope = "jaas", name = "roledel", description = "Delete a role from a user.")
public class RoleDeleteCommand extends JaasCommandSupport {

    @Argument(index = 0, name = "username", description = "User Name", required = true, multiValued = false)
    private String username;

    @Argument(index = 1, name = "role", description = "Role", required = true, multiValued = false)
    private String role;

    /**
     * Execute the RoleDeleteCommand in the given Excecution Context.
     *
     * @param engine
     * @return
     * @throws Exception
     */
    @Override
    protected Object doExecute(BackingEngine engine) throws Exception {
        engine.deleteRole(username, role);
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDeleteCommand{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
