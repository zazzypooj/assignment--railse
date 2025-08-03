Bug Fixes
Duplicate Tasks on Reassignment: Fixed! When a task is reassigned, the original one is now marked as CANCELLED to avoid clutter.

Too Many Tasks Showing Up: Tasks marked CANCELLED are now excluded from date-based views for a cleaner experience.

✨ New Features
Smart Daily View: See all tasks that are either newly created today or older ones that are still open — so nothing slips through the cracks.

Task Prioritization: Tasks can be marked as HIGH, MEDIUM, or LOW. You can also update and filter them based on priority.

Comments & Activity Logs: Add comments to tasks, and the system automatically tracks any changes to their status or priority.


Assign tasks by reference (Bug #1 is here)
This assigns all tasks for reference_id: 201 to assignee_id: 5.

curl --location 'http://localhost:8080/task-mgmt/assign-by-ref' \
--header 'Content-Type: application/json' \
--data '{
   "reference_id": 201,
   "reference_type": "ENTITY",
   "assignee_id": 5
}'
Fetch tasks by date (Bug #2 is here)
This fetches tasks for assignees 1 and 2. It incorrectly includes cancelled tasks.

curl --location 'http://localhost:8080/task-mgmt/fetch-by-date/v2' \
--header 'Content-Type: application/json' \
--data '{
   "start_date": 1672531200000,
   "end_date": 1735689599000,
   "assignee_ids": [1, 2]
}'

🛠️ Built With
Java 17 – modern and fast

Spring Boot 3.0.4 – for rapid backend development

Gradle – for building and managing dependencies

Lombok & MapStruct – to reduce boilerplate code

In-memory storage – using simple Map and List, no database needed!

