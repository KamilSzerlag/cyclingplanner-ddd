package pl.ksz.cyclingplanner.util;

/**
 *  Indicates that an annotated class is an "Aggregate". According to Marting Fowler: A DDD aggregate
 *  is a cluster of domain objects that can be treated as a single unit. An example may be an order
 *  and its line-items, these will be separate objects, but it's useful to treat the order (together
 *  with its line items) as a single aggregate.
 */
public @interface Aggregate {

}
