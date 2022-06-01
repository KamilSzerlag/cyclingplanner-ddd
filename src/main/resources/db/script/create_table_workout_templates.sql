create table workout_template.workout_templates
(
    id                             uuid    not null
        constraint workout_templates_pk
            primary key,
    name                           varchar not null check (length(name) < 200),
    workout_performance_parameters jsonb,
    owner_id                       uuid    not null
);

create unique index workout_templates_id_uindex
    on workout_template.workout_templates (id);


