CREATE TABLE bio_data (
                                 user_id UUID PRIMARY KEY
                                     REFERENCES users(id)
                                         ON DELETE CASCADE,

    -- Basic Personal Info
                                 gender            VARCHAR(20) NOT NULL,
                                 date_of_birth     DATE NOT NULL,
                                 place_of_birth    VARCHAR(50) NULL,
                                 height            VARCHAR(10),
                                 weight            SMALLINT,
                                 blood_group       VARCHAR(5),
                                 marital_status    VARCHAR(50) NOT NULL, -- NEVER_MARRIED, DIVORCED, etc.

    -- Location
                                 present_address              VARCHAR(100),
                                 permanent_address              VARCHAR(100),
                                 city              VARCHAR(100),
                                 state             VARCHAR(100),
                                 country           VARCHAR(100),

    -- Religion & Culture
                                 religion          VARCHAR(50),

    -- Education & Profession
                                 highest_education VARCHAR(150),
                                 field_of_study    VARCHAR(150),
                                 occupation        VARCHAR(150),
                                 company_name      VARCHAR(200),
                                 annual_income     INTEGER,
                                 currency          VARCHAR(10),

    -- Family Info
                                 father_name VARCHAR(150),
                                 father_occupation VARCHAR(150),
                                 mother_name VARCHAR(150),
                                 mother_occupation VARCHAR(150),
                                 siblings_count    SMALLINT,
                                 family_type       VARCHAR(50),   -- Nuclear / Joint
                                 family_details    TEXT,   -- Nuclear / Joint
                                 family_status     VARCHAR(50),   -- Middle / Upper / Rich

    -- Lifestyle
                                 diet              VARCHAR(50),   -- Veg / Non-Veg
                                 smoking           BOOLEAN,
                                 drinking          BOOLEAN,

    -- About
                                 about_me            TEXT,
                                 partner_expectation TEXT,
                                 preferred_age            VARCHAR(50),
                                 preferred_education      VARCHAR,
                                 preferred_profession     VARCHAR,
                                 preferred_location       VARCHAR,
                                 shift_abroad             BOOLEAN,


    -- Media
                                 profile_picture_url TEXT,
                                 gallery_urls        JSONB,

    -- Preferences / Matching Flags

    -- Privacy
                                 is_public      BOOLEAN DEFAULT FALSE,
                                 show_contact   BOOLEAN DEFAULT FALSE,

    -- Audit
                                 created_at TIMESTAMPTZ DEFAULT NOW(),
                                 updated_at TIMESTAMPTZ DEFAULT NOW()
);