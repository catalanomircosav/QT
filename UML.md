@startuml

class Attribute {
  - name : String
  - index : int

  # Attribute(name : String, index : int)
  
  + getName() : String
  + getIndex() : int
  + toString() : String
}

class ContinuousAttribute {
  - max : double
  - min : double
  
  # ContinuousAttribute(name : String, index : int, min : double, max : double)

  + getScaledValue(v : double) : double
}

class ContinuousItem {
  note right of ContinuousItem
  To be implemented
end note
}

class Data {
  - data : Object[][]
  - numberOfExamples : int
  - attributeSet : Attribute[]

  # Data()

  + getNumberOfExamples() : int
  + getNumberOfAttributes() : int
  + getAttributeSchema() : Attribute[]
  + getValue(exampleIndex : int, attributeIndex : int) : Object
  + getAttribute(index : int) : Attribute
  + toString() : String
}

class DiscreteAttribute {
  - values : String[]

  # DiscreteAttribute(name : String, index : int, values : String[])

  + getNumberOfDistinctValues() : int
  + getValue(i : int) : String
}

class DiscreteItem {
  - attribute : DiscreteAttribute
  - value : String
  
  # DiscreteItem(attribute : DiscreteAttribute, value : String)

  + distance(obj : Object) : double
}

class Item {
  - attribute : Attribute
  - value : Object

  # Item(attribute : Attribute, value : Object)

  + protected abstract distance(a : Object) : double
  + getAttribute() : Attribute
  + getValue() : Object
  + toString() : String
}

class Tuple {
  - tuple : Item[]

  # Tuple(size : int)

  + getLength() : int
  + get(i : int) : Item
  + add(c : Item, i : int) : void
  + getDistance(obj : Tuple) : double
  + avgDistance(data : Data, clusteredData : int[]) : double
}

class Cluster {
  - centroid : Tuple
  - clusteredData : ArraySet

  # Cluster(centroid : Tuple)

  + getCentroid() : Tuple
  + addData(id : int) : boolean
  + contain(id : int) : boolean
  + removeTuple(id : int) : void
  + getSize() : int
  + iterator() : int[]
  + toString() : String
  + toString(data : Data) : String
}

class ClusterSet {
  - C : Cluster[]

  # ClusterSet()

  + add(c : Cluster) : void
  + get(i : int) : Cluster
  + toString() : String
  + toString(data : Data) : String
}

class QTMiner {
  - C : ClusterSet
  - radius : double

  # QTMiner(radius : double)

  + getC() : ClusterSet
  + compute(data : Data) : int
  + buildCandidateCluster(data : Data) : Cluster
}

class ArraySet {
  - set : boolean[]
  - size : int
  - cardinality : int

  # ArraySet()

  + add(i : int) : boolean
  + delete(i : int) : boolean
  + get(i : int) : boolean
  + toArray() : int[]
}

class ClusteringRadiusException {
  # ClusteringRadiusException(message : String)
}

class EmptyDatasetException {
  # EmptyDatasetException()
  # EmptyDatasetException(msg : String)
}

class MainTest {
  + main(args : String[]) : void
}

Data "1" *-- "many" Attribute : contains
DiscreteItem "1" *-- "1" DiscreteAttribute : uses
Item "1" *-- "1" Attribute : has
Item "1" *-- "1" Object : stores
Tuple "1" *-- "many" Item : contains
Cluster "1" *-- "1" Tuple : has
Cluster "1" *-- "many" ArraySet : stores
QTMiner "1" *-- "1" ClusterSet : manages
ClusterSet "1" *-- "many" Cluster : contains

Attribute <|-- ContinuousAttribute
Attribute <|-- DiscreteAttribute

ContinuousItem "1" *-- "1" ContinuousAttribute : uses

Data --> EmptyDatasetException : throws
QTMiner --> EmptyDatasetException : throws
QTMiner --> ClusteringRadiusException : throws
MainTest --> EmptyDatasetException : handles
MainTest --> ClusteringRadiusException : handles

@enduml
