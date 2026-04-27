package com.sci.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {

    // Built ONCE — expensive operation, thread-safe
    public static final SessionFactory SESSION_FACTORY =
            new Configuration()   // reads hibernate.cfg.xml
                    .configure()          // loads entity mappings
                    .buildSessionFactory();

    public static void shutdown() {
        SESSION_FACTORY.close();  // release JDBC connections
    }
}