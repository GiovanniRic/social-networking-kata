# Social Networking Kata

Simple project in Java that simulate the social network with console.
It's possible to do 3 actions:

- Posting
- Reading
- Following (wall)

Examples

Posting
Users can be publish message:
- Jack -> I'm happy today!        -- Command
- Marie -> Boring the school!     -- Command
- Jack -> I'm tired now.          -- Command
     


Reading
User can be read message others users:
- Jack -- Command

-  I'm tired now. (3 minutes ago) --- Result
-  I'm happy today! (7 hours ago) --- Result



Following
User can be follow other users:
- Marie follows Jack -- Command
- Marie wall         -- Command

- Jack - I'm tired now. (3 minutes ago)       -- Result
- Marie -> Boring the school! (6 hours ago)   -- Result
- Jack -> I'm happy today! (7 hours ago)      -- Result






# Configure e build:
- Convert the project in Maven Project
- Set the compiler for project with JDK 1.8
- Run Maven install for build and run tests (with JDK 1.8)

Run:
- Start the program as Java Application from class SocialKataApplication.java
