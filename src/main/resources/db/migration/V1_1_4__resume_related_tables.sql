-- =====================================================================
-- Main profile table (1:1 relationship with users)
-- =====================================================================
CREATE TABLE user_profiles (
                               user_id             UUID PRIMARY KEY
                                   REFERENCES users(id)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE,

    -- Basic display / resume header info
                               headline            VARCHAR(200),                    -- e.g. "Senior Backend Engineer | Java & Spring Boot"
                               current_designation VARCHAR(150),
                               profile_picture_url TEXT,
                               cover_photo_url     TEXT,
                               introduction        TEXT,                            -- long self-introduction / summary / objective
                               open_to_work        BOOLEAN DEFAULT FALSE,

    -- Optional contact fields (you can keep these here or move to separate table)
                               email               VARCHAR(255),
                               phone               VARCHAR(50),
                               linkedin_url        VARCHAR(512),
                               github_url          VARCHAR(512),
                               personal_website    VARCHAR(512),

    -- Audit & visibility
                               is_public           BOOLEAN DEFAULT FALSE,           -- whether this profile is visible publicly
                               last_updated_at     TIMESTAMPTZ DEFAULT NOW(),
                               version             INTEGER DEFAULT 1                 -- optional: for optimistic locking or resume versions
);

-- =====================================================================
-- Education (1 user_profile → many educations)
-- =====================================================================
CREATE TABLE profile_educations (
                                    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                    user_id         UUID NOT NULL
                                        REFERENCES users(id)
                                            ON DELETE CASCADE,

                                    degree          VARCHAR(200) NOT NULL,
                                    institution     VARCHAR(300) NOT NULL,
                                    field_of_study  VARCHAR(200),
                                    start_year      SMALLINT,
                                    end_year        SMALLINT,                   -- NULL = ongoing
                                    start_date      DATE,
                                    end_date        DATE,
                                    is_current      BOOLEAN DEFAULT FALSE,
                                    description     TEXT,                       -- additional notes, achievements, GPA, etc.

                                    display_order   SMALLINT DEFAULT 0,
                                    created_at      TIMESTAMPTZ DEFAULT NOW(),
                                    updated_at      TIMESTAMPTZ DEFAULT NOW()
);

-- =====================================================================
-- Work Experience (1 → many)
-- =====================================================================
CREATE TABLE profile_experiences (
                                     id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                     job_title       VARCHAR(200) NOT NULL,
                                     company_name    VARCHAR(200) NOT NULL,
                                     company_url     VARCHAR(512),
                                     location        VARCHAR(150),
                                     start_date      DATE,
                                     end_date        DATE,
                                     is_current      BOOLEAN DEFAULT FALSE,
                                     duration_text   VARCHAR(100),               -- "Aug 2023 – Mar 2025" (human readable fallback)

    -- Bullet points stored as JSONB array
                                     responsibilities JSONB,                    -- ["bullet 1", "bullet 2", ...]

                                     display_order   SMALLINT DEFAULT 0,
                                     created_at      TIMESTAMPTZ DEFAULT NOW(),
                                     updated_at      TIMESTAMPTZ DEFAULT NOW()
);

-- =====================================================================
-- Projects (1 → many)
-- =====================================================================
CREATE TABLE profile_projects (
                                  id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                  title           VARCHAR(300) NOT NULL,
                                  project_url     VARCHAR(512),
                                  start_date      DATE,
                                  end_date        DATE,
                                  is_ongoing      BOOLEAN DEFAULT FALSE,

    -- Bullet points
                                  description     JSONB,                      -- array of strings

    -- Technologies used (array of strings)
                                  technologies    JSONB,

                                  display_order   SMALLINT DEFAULT 0,
                                  created_at      TIMESTAMPTZ DEFAULT NOW(),
                                  updated_at      TIMESTAMPTZ DEFAULT NOW()
);

-- =====================================================================
-- Skills – categorized (flexible & queryable)
-- =====================================================================
CREATE TABLE profile_skills (
                                id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                category        VARCHAR(50) NOT NULL
                                    CHECK (category IN ('languages', 'frameworks', 'tools', 'concepts', 'databases', 'other')),

                                skill_name      VARCHAR(150) NOT NULL,
                                proficiency     VARCHAR(50),                -- 'Expert', 'Advanced', 'Intermediate', 'Beginner'
                                years_of_experience SMALLINT,

                                display_order   SMALLINT DEFAULT 0,
                                created_at      TIMESTAMPTZ DEFAULT NOW(),

                                UNIQUE (user_id, category, skill_name)
);

-- =====================================================================
-- Spoken Languages
-- =====================================================================
CREATE TABLE profile_languages (
                                   id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                   user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                   language_name   VARCHAR(100) NOT NULL,
                                   proficiency     VARCHAR(50),                -- "Native", "Fluent", "C1", "B2", "A2 (CEFR)"

                                   display_order   SMALLINT DEFAULT 0,
                                   created_at      TIMESTAMPTZ DEFAULT NOW(),

                                   UNIQUE (user_id, language_name)
);

-- =====================================================================
-- Certifications
-- =====================================================================
CREATE TABLE profile_certifications (
                                        id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                        user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                        title           VARCHAR(300) NOT NULL,
                                        issuing_organization VARCHAR(200),
                                        issue_date      DATE,
                                        expiry_date     DATE,
                                        credential_id   VARCHAR(100),
                                        credential_url  VARCHAR(512),
                                        description     TEXT,

                                        display_order   SMALLINT DEFAULT 0,
                                        created_at      TIMESTAMPTZ DEFAULT NOW()
);

-- =====================================================================
-- Publications / Papers
-- =====================================================================
CREATE TABLE profile_publications (
                                      id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                      user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                      title           VARCHAR(400) NOT NULL,
                                      publication_date DATE,
                                      publisher       VARCHAR(200),
                                      url             VARCHAR(512),
                                      description     TEXT,

                                      display_order   SMALLINT DEFAULT 0,
                                      created_at      TIMESTAMPTZ DEFAULT NOW()
);

-- =====================================================================
-- Hobbies / Interests (simple list)
-- =====================================================================
CREATE TABLE profile_hobbies (
                                 id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 user_id         UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,

                                 name            VARCHAR(150) NOT NULL,
                                 display_order   SMALLINT DEFAULT 0,
                                 created_at      TIMESTAMPTZ DEFAULT NOW(),

                                 UNIQUE (user_id, name)
);

-- =====================================================================
-- Optional: indexes for common queries
-- =====================================================================

CREATE INDEX idx_profile_educations_user_id ON profile_educations(user_id);
CREATE INDEX idx_profile_experiences_user_id ON profile_experiences(user_id);
CREATE INDEX idx_profile_projects_user_id ON profile_projects(user_id);
CREATE INDEX idx_profile_skills_user_id_category ON profile_skills(user_id, category);
CREATE INDEX idx_profile_languages_user_id ON profile_languages(user_id);