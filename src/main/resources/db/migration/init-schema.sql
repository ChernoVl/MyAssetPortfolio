CREATE TABLE diller
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    commission DECIMAL,
    CONSTRAINT pk_diller PRIMARY KEY (id)
);

CREATE TABLE "order"
(
    id          BIGINT NOT NULL,
    amount      DOUBLE,
    buying_date TIMESTAMP,
    price_id    BIGINT,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

CREATE TABLE price
(
    id                   BIGINT NOT NULL,
    brutto               DECIMAL,
    stock_purchase_price DECIMAL,
    stock_wrapper_id     BIGINT,
    diller_id            BIGINT,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE stock_wrapper
(
    id           BIGINT NOT NULL,
    full_name    VARCHAR(255),
    ticker       VARCHAR(255),
    curr_price   DECIMAL,
    updated_date TIMESTAMP,
    CONSTRAINT pk_stockwrapper PRIMARY KEY (id)
);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE price
    ADD CONSTRAINT FK_PRICE_ON_DILLER FOREIGN KEY (diller_id) REFERENCES diller (id);

ALTER TABLE price
    ADD CONSTRAINT FK_PRICE_ON_STOCK_WRAPPER FOREIGN KEY (stock_wrapper_id) REFERENCES stock_wrapper (id);