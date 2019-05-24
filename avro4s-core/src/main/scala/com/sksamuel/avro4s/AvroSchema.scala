package com.sksamuel.avro4s

import org.apache.avro.Schema

object AvroSchema {

  /**
    * Creates an Avro Schema for an arbitrary type T.
    *
    * Requires an instance of [[SchemaFor]] which is usually
    * generated by the avro4s macros.
    *
    * Usage:
    *
    * val schema = AvroSchema[MyType]
    *
    * An implicit [[NamingStrategy]] can be provided to override
    * how the field names are generated.
    */
  def apply[T](implicit schemaFor: SchemaFor[T],
               naming: NamingStrategy = DefaultNamingStrategy): Schema = schemaFor.withNamingStrategy(naming).schema
}
