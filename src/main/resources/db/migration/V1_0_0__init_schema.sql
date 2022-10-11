-- DROP TABLE IF EXISTS "ORDER";
-- DROP TABLE IF EXISTS PRICE;
-- DROP TABLE IF EXISTS STOCK_WRAPPER;
-- DROP TABLE IF EXISTS DILLER;

CREATE TABLE DILLER
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    commission DECIMAL,
    CONSTRAINT pk_diller PRIMARY KEY (id)
);

CREATE TABLE STOCK
(
    id           BIGINT NOT NULL,
    full_name    VARCHAR(255),
    ticker       VARCHAR(255),
    curr_price   DECIMAL,
    updated_date TIMESTAMP,
    CONSTRAINT pk_stockwrapper PRIMARY KEY (id)
);

CREATE TABLE PRICE
(
    id                   BIGINT NOT NULL,
    brutto               DECIMAL,
    stock_purchase_price DECIMAL,
    stock_wrapper_id     BIGINT,
    diller_id            BIGINT,
    CONSTRAINT pk_price PRIMARY KEY (id)
);


CREATE TABLE "ORDER"
(
    id          BIGINT NOT NULL,
    amount      DOUBLE,
    buying_date TIMESTAMP,
    price_id    BIGINT,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

ALTER TABLE "ORDER"
    ADD CONSTRAINT FK_ORDER_ON_PRICE FOREIGN KEY (price_id) REFERENCES PRICE (id);

ALTER TABLE PRICE
    ADD CONSTRAINT FK_PRICE_ON_DILLER FOREIGN KEY (diller_id) REFERENCES DILLER (id);

ALTER TABLE PRICE
    ADD CONSTRAINT FK_PRICE_ON_STOCK_WRAPPER FOREIGN KEY (stock_wrapper_id) REFERENCES STOCK (id);
