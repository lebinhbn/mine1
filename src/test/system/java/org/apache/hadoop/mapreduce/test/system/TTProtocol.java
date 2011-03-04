/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.mapreduce.test.system;

import java.io.IOException;

import org.apache.hadoop.mapred.JobTracker;
import org.apache.hadoop.mapred.TaskTracker;
import org.apache.hadoop.mapred.TaskTrackerStatus;
import org.apache.hadoop.mapreduce.TaskID;
import org.apache.hadoop.test.system.DaemonProtocol;

/**
 * TaskTracker RPC interface to be used for cluster tests.
 */
public interface TTProtocol extends DaemonProtocol {

  public static final long versionID = 1L;
  /**
   * Gets latest status which was sent in heartbeat to the {@link JobTracker}. 
   * <br/>
   * 
   * @return status
   * @throws IOException
   */
  TaskTrackerStatus getStatus() throws IOException;

  /**
   * Gets list of all the tasks in the {@link TaskTracker}.<br/>
   * 
   * @return list of all the tasks
   * @throws IOException
   */
  TTTaskInfo[] getTasks() throws IOException;

  /**
   * Gets the task associated with the id.<br/>
   * 
   * @param id of the task.
   * 
   * @return
   * @throws IOException
   */
  TTTaskInfo getTask(TaskID taskID) throws IOException;
}
